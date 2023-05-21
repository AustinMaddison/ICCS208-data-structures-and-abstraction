package game;
import game.parser.Parser;
import game.room.Room;
import game.command.*;

/* use NORTH EAST SOUTH WEST without Command.Direction prefix*/
import static game.command.CommandDirection.*;

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
    private Parser parser;
    private Room currentRoom;
        
    /**
     * Create the game and initialise its internal map.
     */
    public Game() {
        createRooms();
        parser = new Parser();
    }

    /**
     * Create all the rooms and link their exits together.
     */
    private void createRooms() {
        Room outside, theater, bathroom, lab, office, hallwayFl1, hallwayFl2, stairwayFl1, stairwayFl2;
      
        // create the rooms
        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        bathroom = new Room("in the bathroom");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");
        hallwayFl1 = new Room("in the 1st Floor hallway");
        hallwayFl2 = new Room("in the 2nd Floor hallway");
        stairwayFl1 = new Room("in the 1st Floor stairway");
        stairwayFl2 = new Room("in the 1st Floor stairway");

        // initialise room exits

        outside.setExit(NORTH, hallwayFl1);
        hallwayFl1.setExit(NORTH, stairwayFl1);
        hallwayFl1.setExit(EAST, lab);
        lab.setExit(SOUTH, office);
        hallwayFl1.setExit(WEST, bathroom);
        stairwayFl1.setExit(UP, stairwayFl2);
        stairwayFl2.setExit(SOUTH, hallwayFl2);
        stairwayFl2.setExit(EAST, theater);

//        outside.setExits(hallwayFl1, null, null, null);
//        hallwayFl1.setExits(stairwayFl1, lab, outside, bathroom);
//        stairwayFl1.setExits(null, null, hallwayFl1, null, hallwayFl2, null);
//        stairwayFl2.setExits(null, null, hallwayFl2, null, null, stairwayFl1);
//        hallwayFl1.setExits(stairwayFl1, theater, null, null);
//        lab.setExits(null, null, office, hallwayFl1);
//        office.setExits(lab, null, null, null);
//        theater.setExits(null, null, null, outside);
//        bathroom.setExits(null, hallwayFl1, null, null);

        currentRoom = outside;  // start game outside
    }

    /**
     *  game.Main play routine. Loops until end of play.
     */
    public void play() {
        System.out.println('\n' + getWelcomeMessage() + '\n');

        // Enter the main command loop.  Here we repeatedly read commands and
        // execute them until the game is over.

        boolean finished = false;
        while (!finished) {
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
        welcomeMsg.append("Welcome to the World of Zuul!");
        welcomeMsg.append("World of Zuul is a new, incredibly boring adventure game.");
        welcomeMsg.append("Type 'help' if you need help.");

        return welcomeMsg.toString();
    }

    /**
     * Return details of the current location and exits.
     * @return Details of the current location and exits.
     * */
    private String getLocationInfo() {
        StringBuilder info = new StringBuilder();
        info.append("You are ").append(currentRoom.getDescription());
        info.append('\n');
        info.append("Exits: ");
        info.append(currentRoom.getAllExits());

        return info.toString();
    }


    /**
     * Given a command, process (that is: execute) the command.
     * @param command The command to be processed.
     * @return true If the command ends the game, false otherwise.
     */
    private boolean processCommand(Command command) 
    {
        boolean wantToQuit = false;

        CommandAction commandWord = command.getCommandAction();
        switch (commandWord) {
            case UNKNOWN:
                System.out.println("I don't know what you mean...");
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

    // implementations of user commands:

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

        helpMsg.append("Your command words are:");
        helpMsg.append(CommandAction.getCommandActions());

        return helpMsg.toString();
    }

    /** 
     * Try to go in one direction. If there is an exit, enter
     * the new room, otherwise print an error message.
     */
    private void goRoom(Command command) {
        if(!command.hasSecondWord()) {
            // if there is no second word, we don't know where to go...
            System.out.println("Go where?");
            return;
        }

        /* Uses hash map to retrieve next room */
        Room nextRoom = currentRoom.getExit(command.getCommandDirection());

        if (nextRoom == null) {
            System.out.println("There is no door!");
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
    private boolean quit(Command command) 
    {
        if(command.hasSecondWord()) {
            System.out.println("Quit what?");
            return false;
        }
        else {
            return true;  // signal that we want to quit
        }
    }
}
