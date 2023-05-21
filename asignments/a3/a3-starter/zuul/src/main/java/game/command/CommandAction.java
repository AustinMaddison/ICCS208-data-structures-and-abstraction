package game.command;

public enum CommandAction {

        // Gameplay Actions
        GO, LOOK, HELP,

        // User Actions
        QUIT,

        // Utility
        UNKNOWN;

        /**
         * @return Returns all available player action commands.
         */
        public static String getCommandActions() {
                StringBuilder allCmd = new StringBuilder();
                for(CommandAction commandAction: CommandAction.values()) {
                        if (commandAction != CommandAction.UNKNOWN) {
                                allCmd.append(commandAction.toString().toLowerCase()).append(' ');
                        }
                }
                return allCmd.toString();
        }


        }
