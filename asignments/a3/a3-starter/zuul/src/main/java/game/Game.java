package game;
import game.color.TerminalColor;
import game.history.History;
import game.map.Map;
import game.message.MessageProvider;
import game.parser.Parser;
import game.map.Room;
import game.command.*;

/* use NORTH EAST SOUTH WEST without CommandDirection prefix */
import java.io.File;
import java.nio.file.Paths;
import java.util.ArrayDeque;

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
    private MessageProvider messageProvider;
    private Parser parser;
//    private Room currentRoom;
    private History<Room> roomHistory;
    private Room currentRoom;
    private Map map;

        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        // Initialize Game Map
        map = new Map(mapFile);
        roomHistory = new History<>();
        roomHistory.update(map.getRoom("outside"));
        currentRoom = roomHistory.getCurrentState();

        // Initialize user input parse
        parser = new Parser();

        // Initialize game messages and output terminal colors.
        terminalColor = new TerminalColor(ANSI_RESET, ANSI_BLACK_BACKGROUND);
        messageProvider = new MessageProvider(terminalColor);
    }


    /**
     *  game.Main play routine. Loops until end of play.
     */
    public void play() {
        System.out.println(messageProvider.getWelcomeMessage());

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
            currentRoom = roomHistory.getCurrentState();

            System.out.print('\n');
            System.out.println(messageProvider.getLocationInfo(currentRoom));
            Command command = parser.getCommand();
            finished = processCommand(command);
        }

        System.out.println(messageProvider.quitGameMessage());
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

            case BACK:
                goBack();
                break;


            case LOOK:
                messageProvider.getLocationInfo(currentRoom);
                break;

            case HELP:
                System.out.println(messageProvider.getHelpMessage(currentRoom));
                break;

            case QUIT:
                wantToQuit = quit(command);
                break;
        }
        return wantToQuit;
    }

    /* implementations of user commands */

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
        if (nextRoom.getName() == "warp") {
            System.out.println(messageProvider.warpMessage());
            roomHistory.update( map.getRandomRoom());
        }
        else {
            roomHistory.update(nextRoom);
        }
    }

    private void goBack() {
        if(roomHistory.getSize() == 1) {
            System.out.println(ANSI_RED + "You haven't been anywhere yet!" +terminalColor.reset());
        }
        else {
            roomHistory.undo();
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


