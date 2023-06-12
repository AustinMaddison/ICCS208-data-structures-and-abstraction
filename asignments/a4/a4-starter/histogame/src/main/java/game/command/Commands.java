package game.command;

import java.util.HashMap;

public class Commands {
    // a constant array that holds all valid command words
    private static HashMap<String, CommandAction> validActions;
    /**
     * Constructor - initialise the command validator hashmaps.
     */
    public Commands() {
        validActions = new HashMap<String, CommandAction>();

        validActions.put("?", CommandAction.INFO);
        validActions.put("!", CommandAction.RESET);
        validActions.put("q", CommandAction.QUIT);
    }

    /**
     * Check whether a given String is a valid command word. 
     * @return true if a given string is a valid command,
     * false if it isn't.
     */
    public  CommandAction getCommandAction(String commandAction) {

        // Check if it is a command: q - quit, ? - help, ! - give-up
        if(commandAction != null) {
            CommandAction command = validActions.get(commandAction.toLowerCase());

            if(command != null) {
                return command;
            }
        }



        // if we get here, it is not a command and has to be a guess for a word.
        return CommandAction.GUESS;
    }

}
