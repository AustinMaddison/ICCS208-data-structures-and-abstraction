package game.command;

public class Command {
    private CommandAction commandAction;
    private String commandWord;


    /**
     * Create a command object. First and second word must be supplied, but
     * either one (or both) can be null.
     * @param commandAction The first word of the command. Null if the command
     *                  was not recognised.
     */
    public Command(CommandAction commandAction, String commandWord) {
        this.commandAction = commandAction;
        this.commandWord = commandWord;
    }

    /**
     * Return the command word (the first word) of this command. If the
     * command was not understood, the result is null.
     * @return The command word.
     */
    public CommandAction getCommandAction() {
        return commandAction;
    }

    public String getWord() {
        return commandWord;
    }

    /**
     * @return true if this command was not understood.
     */
    public boolean isActionUnknown() {
        return (commandAction == CommandAction.GUESS);
    }
}

