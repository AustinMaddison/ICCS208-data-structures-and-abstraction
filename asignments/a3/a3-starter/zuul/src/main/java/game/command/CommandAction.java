package game.command;

public enum CommandAction {

    // Gameplay Actions
    GO, LOOK, HELP, BACK,

    // User Actions
    QUIT,

    // Utility
    UNKNOWN;

    /**
     * @return Returns all available player action commands.
     */
    public static String getAllCommandActions() {
        StringBuilder allCmd = new StringBuilder();

        // loop appends all commands in this enum class into a string.

        for(CommandAction commandAction: CommandAction.values()) {
            if (commandAction != CommandAction.UNKNOWN) {
                allCmd.append(commandAction.toString().toLowerCase()).append(' ');
            }
        }

        return allCmd.toString();
    }


}
