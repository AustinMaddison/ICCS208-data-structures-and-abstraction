package game.command;

import java.util.HashMap;

/**
 * This class is part of the "World of Zuul" application. 
 * "World of Zuul" is a very simple, text based adventure game.  
 * 
 * This class holds an enumeration of all command words known to the game.
 * It is used to recognise commands as they are typed in.
 *
 * @author  Michael Kölling and David J. Barnes
 * @version 2016.02.29
 */

public class CommandWords {
    // a constant array that holds all valid command words
    private HashMap<String, CommandAction> validActions;
    private HashMap<String, CommandDirection> validDirections;

    /**
     * Constructor - initialise the command words.
     */
    public CommandWords() {
        validActions = new HashMap<String, CommandAction>();
        validDirections = new HashMap<String, CommandDirection>();

        for(CommandAction command: CommandAction.values()) {
            validActions.put(command.toString().toLowerCase(), command);
        }

        for(CommandDirection command: CommandDirection.values()) {
            validDirections.put(command.toString().toLowerCase(), command);
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public CommandAction getCommandAction(String commandAction) {
        CommandAction command = validActions.get(commandAction);
        if(command != null) {
            return command;
        }
        // if we get here, the string was not found in the commands
        return CommandAction.UNKNOWN;
    }

    public CommandDirection getCommandDirection(String commandDirection) {
        CommandDirection command = validDirections.get(commandDirection);
        if(command != null) {
            return command;
        }
        // if we get here, the string was not found in the commands
        return CommandDirection.UNKNOWN;
    }

}
