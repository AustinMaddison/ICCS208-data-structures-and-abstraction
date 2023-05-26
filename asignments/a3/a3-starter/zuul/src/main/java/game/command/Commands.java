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

public class Commands {
    // a constant array that holds all valid command words
    private static HashMap<String, CommandAction> validActions;
    private static HashMap<String, CommandActionParam> validDirections;

    /**
     * Constructor - initialise the command validator hashmaps.
     */
    public Commands() {
        validActions = new HashMap<String, CommandAction>();
        validDirections = new HashMap<String, CommandActionParam>();

        for(CommandAction command: CommandAction.values()) {
            validActions.put(command.toString().toLowerCase(), command);
        }

        for(CommandActionParam command: CommandActionParam.values()) {
            validDirections.put(command.toString().toLowerCase(), command);
        }
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public  CommandAction getCommandAction(String commandAction) {
        CommandAction command = validActions.get(commandAction.toLowerCase());
        if(command != null) {
            return command;
        }
        // if we get here, the string was not found in the commands
        return CommandAction.UNKNOWN;
    }

    public  CommandActionParam getCommandParameter(String commandParameter) {
       if(commandParameter == null) {
           return CommandActionParam.EMPTY;
       }

        CommandActionParam command = validDirections.get(commandParameter.toLowerCase());
        if(command != null) {
            return command;
        }

        // if we get here, the string was not found in the commands
        return CommandActionParam.UNKNOWN;
    }

}
