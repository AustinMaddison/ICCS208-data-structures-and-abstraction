package game;

import game.color.TerminalColor;
import game.command.Command;
import game.command.CommandAction;
import game.message.MessageProvider;
import game.parser.Parser;
import game.word.Word;
import game.word.WordBoard;

import static game.color.TerminalColor.*;

/**
 * This class is the main class for the Text Twist game,
 * the Zuul adventure game classes was repurposed for this game.
 *
 * @author Austin J. Maddison
 * @version 2023.06.8
 */

public class Game {

    /* Resources */
    String wordDatabaseFileName = "linuxwords.txt";


    /* Game Systems */
    private WordBoard wordBoard; // words to guess correctly.
    private int points;
    private int maxPoints;
    private String lastWord;
    private TerminalColor terminalColor;
    private MessageProvider messageProvider;
    private Parser parser;


    /**
     * Create the game .
     */
    public Game() {
        // Initialize game systems and parameters.
        parser = new Parser();
        terminalColor = new TerminalColor(ANSI_RESET, ANSI_BLACK_BACKGROUND);
        messageProvider = new MessageProvider(terminalColor);
        wordBoard = new WordBoard(wordDatabaseFileName);
        points = 0;
    }


    /**
     * game.Main play routine. Loops until end of play.
     */
    public void play() {
        System.out.println(messageProvider.welcomeUI());

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            messageProvider.update(points, maxPoints, lastWord, wordBoard );

            if(isWinner()) {
                restartGame(true);
                continue;
            }

            System.out.print('\n');
            System.out.println(wordBoard.getJumbledWord());
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println(messageProvider.quitGameUI());
    }

    /**
     * Given a command, process (that is: execute) the command.
     *
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandAction commandWord = command.getCommandAction();
        switch (commandWord) {
            case GUESS:
                proccessGuess(command.getWord());
                break;

            case INFO:
                System.out.println(messageProvider.gameBoardInfoUI(false));
                break;

            case RESET:
                restartGame(false);
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    private boolean isWinner() {
        return points >= maxPoints;
    }

    private void restartGame(boolean won) {
        System.out.println(messageProvider.gameBoardInfoUI(true));
        System.out.println(messageProvider.restartUI(won));
        wordBoard.initialize();
        points = 0;
        maxPoints = wordBoard.size();
        messageProvider.update(points, maxPoints, lastWord, wordBoard );
    }

    private void changeScore(int points){
        points += points;
    }

    /* implementations of user commands */

    /**
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void proccessGuess(String guess) {
        int containsIdx = wordBoard.contains(new Word(guess));

        if (containsIdx != -1) {
            System.out.println(messageProvider.correctUI());
            wordBoard.isCorrectAtIdx(containsIdx);
            points ++;
        }
        else {
            System.out.println(messageProvider.incorrectUI());
        }
    }


    /**
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     *
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        return true;  // signal that we want to quit
    }

}


