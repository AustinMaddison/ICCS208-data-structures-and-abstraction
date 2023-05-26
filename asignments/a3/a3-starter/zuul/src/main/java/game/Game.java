package game;
import game.color.TerminalColor;
import game.map.Map;
import game.parser.Parser;
import game.map.Room;
import game.command.*;

/* use NORTH EAST SOUTH WEST without CommandDirection prefix */
import java.io.File;
import java.nio.file.Path;
import java.nio.file.Paths;

import static game.command.CommandActionParam.*;

/* use ANSI escape codes without StringColor prefix */
import static game.color.TerminalColor.*;

/**
 *  This class is the main class of the "World of Zuul" application. 
 *  "World of Zuul" is a very simple, text based adventure game.  Users 
 *  can walk around some scenery. That's all. It should really be extended 
 *  to make it more interesting!
 * 
 *  To play this game, create an instance of this class and call the "play"
 *  method.
 * 
 *  This main class creates and initialises all the others: it creates all
 *  rooms, creates the parser and starts the game.  It also evaluates and
 *  executes the commands that the parser returns.
 * 
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class Game {

    /* Resources */
    private File mapFile = Paths.get("src", "main", "java", "game", "Map.csv").toFile();

    /* Private */
    private TerminalColor terminalColor;
    private Parser parser;
    private Room currentRoom;
    private Map map;

        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        map = new Map(mapFile);
        currentRoom = map.getRoom("outside");

        parser = new Parser();
        terminalColor = new TerminalColor(ANSI_RESET, ANSI_BLACK_BACKGROUND);
    }


    /**
     *  game.Main play routine. Loops until end of play.
     */
    public void play() {
        System.out.println(getWelcomeMessage());

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            System.out.print('\n');
            System.out.println(getLocationInfo());
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println("Thank you for playing.  Good bye.");
    }

    /**
     * @return returns welcome message for the opening message for the player.
     */
    private String getWelcomeMessage() {
        StringBuilder welcomeMsg = new StringBuilder();

        welcomeMsg.append("Welcome to the World of Zuul!\n");
        welcomeMsg.append("World of Zuul is a new, incredibly boring adventure game.\n");
        welcomeMsg.append(ANSI_GREEN + "Type 'help' if you need help." + terminalColor.reset());

        return welcomeMsg.toString();
    }

//    private String ge

    /**
     * Return details of the current location and exits.
     * @return Details of the current location and exits.
     * */
    private String getLocationInfo() {
        StringBuilder info = new StringBuilder();

        info.append("You are ").append(currentRoom.getDescription());
        info.append('\n');
        info.append(ANSI_YELLOW + "Exits: " + terminalColor.reset());
        info.append(ANSI_YELLOW + currentRoom.getAllExits() + terminalColor.reset());

        return info.toString();
    }


    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) {
        boolean wantToQuit = false;

        CommandAction commandWord = command.getCommandAction();
        switch (commandWord) {
            case UNKNOWN:
                System.out.println(ANSI_RED + "I don't know what you mean..." + terminalColor.reset());
                break;

            case GO:
                goRoom(command);
                break;

            case LOOK:
                getLocationInfo();
                break;

            case HELP:
                System.out.println(getHelpMessage());
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    /* implementations of user commands */

    /**
     * Print out some help information.
     * Here we print some stupid, cryptic message and a list of the 
     * command words.
     */
    private String getHelpMessage() {
        StringBuilder helpMsg = new StringBuilder();

        helpMsg.append("You are lost. You are alone. You wander");
        helpMsg.append("around at the university.");
        helpMsg.append('\n');
        // Prints all possible commands automatically from CommandAction.
        helpMsg.append(ANSI_BLUE + "Your command words are:\n" + terminalColor.reset());
        helpMsg.append(ANSI_BLUE + CommandAction.getAllCommandActions() + terminalColor.reset());

        return helpMsg.toString();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) {

        if(command.isActionParamUnknown()) {
            // if there is no second word, we don't know where to go...
            System.out.println(ANSI_RED + "Go where?" + terminalColor.reset());
            return;
        }

        // Uses hash map to retrieve next room
        Room nextRoom = currentRoom.getExit(command.getCommandDirection());

        if (nextRoom == null) {
            System.out.println(ANSI_RED + "There is no door!" +terminalColor.reset());
        }
        else {
            currentRoom = nextRoom;
        }
    }

    /** 
     * "Quit" was entered. Check the rest of the command to see
     * whether we really quit the game.
     * @return true, if this command quits the game, false otherwise.
     */
    private boolean quit(Command command) {
        if(!command.isActionParamEmpty()) {
            System.out.println(ANSI_RED + "Quit what?" + terminalColor.reset());
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
