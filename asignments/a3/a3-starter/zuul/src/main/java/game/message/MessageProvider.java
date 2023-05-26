package game.message;

import game.color.TerminalColor;
import game.command.CommandAction;
import game.map.Room;

import static game.color.TerminalColor.*;
import static game.color.TerminalColor.ANSI_YELLOW;

public class MessageProvider {
    TerminalColor terminalColor;
    public MessageProvider(TerminalColor terminalColor) {
        this.terminalColor = terminalColor;
    }


    /**
     * @return returns welcome message for the opening message for the player.
     */
    public String getWelcomeMessage() {
        StringBuilder welcomeMsg = new StringBuilder();

        welcomeMsg.append("Welcome to the World of Zuul!\n");
        welcomeMsg.append("World of Zuul is a new, incredibly boring adventure game.\n");
        welcomeMsg.append(ANSI_GREEN + "Type 'help' if you need help." + terminalColor.reset());

        return welcomeMsg.toString();
    }

    /**
     * Return details of the current location and exits.
     * @return Details of the current location and exits.
     * */
    public String getLocationInfo(Room currentRoom) {
        StringBuilder info = new StringBuilder();

        info.append("You are ").append(currentRoom.getDescription());
        info.append('\n');
        info.append(ANSI_YELLOW + "Exits: " + terminalColor.reset());
        info.append(ANSI_YELLOW + currentRoom.getAllExits() + terminalColor.reset());

        return info.toString();
    }

    /**
     * Reuturns some help information.
     * Current location message and a list of the
     * command words.
     */
    public String getHelpMessage(Room currentRoom) {
        StringBuilder helpMsg = new StringBuilder();

        helpMsg.append(getLocationInfo(currentRoom));
        helpMsg.append('\n');
        // Prints all possible commands automatically from CommandAction.
        helpMsg.append(ANSI_BLUE + "Your command words are:\n" + terminalColor.reset());
        helpMsg.append(ANSI_BLUE + CommandAction.getAllCommandActions() + terminalColor.reset());

        return helpMsg.toString();
    }

    public String warpMessage() {
        StringBuilder warpMsg = new StringBuilder();

        warpMsg.append(ANSI_PURPLE + "You entered magic transporter room, you will be transported to a random room.\n" +
                "*WOOOOOOOOOOOOOSH*" +terminalColor.reset());

        return warpMsg.toString();
    }

    public String quitGameMessage() {
        StringBuilder warpMsg = new StringBuilder();

        warpMsg.append(ANSI_GREEN + "Thank you for playing. Good bye." + terminalColor.reset());

        return warpMsg.toString();
    }
}
