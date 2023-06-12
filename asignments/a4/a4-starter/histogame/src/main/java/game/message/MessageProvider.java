package game.message;

import game.color.TerminalColor;
import game.word.WordBoard;

import static game.color.TerminalColor.*;

public class MessageProvider {
    TerminalColor terminalColor;
    private long startTime = System.currentTimeMillis();
    private boolean firstRun = false;
    private int points;
    private int maxPoints;
    private String lastWord;
    private WordBoard board;
    private static int widthDefault = 82;

    public MessageProvider(TerminalColor terminalColor) {
        this.terminalColor = terminalColor;

    }

    public void update(int points, int maxPoints, String lastWord, WordBoard board) {
        this.points = points;
        this.maxPoints = maxPoints;
        this.lastWord = lastWord;
        this.board = board;
    }

    /**
     * @return returns welcome message for the opening message for the player.
     */
    public String welcomeUI() {
        StringBuilder welcomeMsg = new StringBuilder();

        welcomeMsg.append(
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░\n" +
                        "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                        "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n" +
                        "██████████████████████████████████████████████████████████████████████████████████");

        welcomeMsg.append("\n" +
                "\n" +
                "   ████████ ███████ ██   ██ ████████     ████████ ██     ██ ██ ███████ ████████\n" +
                "      ██    ██       ██ ██     ██           ██    ██     ██ ██ ██         ██    \n" +
                "      ██    █████     ███      ██           ██    ██  █  ██ ██ ███████    ██    \n" +
                "      ██    ██       ██ ██     ██           ██    ██ ███ ██ ██      ██    ██    \n" +
                "      ██    ███████ ██   ██    ██           ██     ███ ███  ██ ███████    ██    \n" +
                "\n");

        welcomeMsg.append(
                "▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀ HOW TO PLAY? ▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀▀\n\n");

        welcomeMsg.append(centerText(82, "Guess words that can be formed using the available letters.") + '\n');
        welcomeMsg.append(ANSI_GREEN + centerText(82, "Type '?' to display info on the number of unformed and formed words.") + '\n' + terminalColor.reset());
        welcomeMsg.append(ANSI_YELLOW + centerText(82, "Type '!' to give up, this will reveal all the words and reset the game.") + '\n' + terminalColor.reset());
        welcomeMsg.append("\n" +

                "██████████████████████████████████████████████████████████████████████████████████\n" +
                "▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓▓\n" +
                "▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒\n" +
                "░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░░");

        return welcomeMsg.toString();
    }

    public String mainGameUI() {

        if(firstRun) {
            String time = 0 + " seconds";
            firstRun = false;
        }
        String time = getTimeString() + " seconds";
        String score = String.format("%d/%d", points, maxPoints);

        StringBuilder sb = new StringBuilder();
        sb.append(String.format("█   ELAPSED TIME : %-19s█    LAST GUESS: %-26s█", time, lastWord)).append("\n");
        sb.append(String.format("█   SCORE        : %-19s█    %s   █", score, getScoreBarUI())).append("\n");
        sb.append(borderText(drawCharLineH(" ", widthDefault)));


        sb.append("█                    COMMANDS: [?]Info [!]Give Up [q]Quit                        █");


        return sb.toString();
    }

    private String getScoreBarUI() {
        StringBuilder sb = new StringBuilder();

        float percent = (float) points / maxPoints * 35;
        int filled = (int) percent;
        sb.append(drawCharLineH("▒",filled -1)).append("▓").append(drawCharLineH("░", 35 - filled));
        return sb.toString();
    }


    private String getTimeString() {
        float sec = (System.currentTimeMillis() - startTime) / 1000F;
        return String.format("%.2f", sec);

    }

    /**
     * Return details of the current location and exits.
     *
     * @return Details of the current location and exits.
     */
    public String gameBoardInfoUI(boolean reveal) {
        StringBuilder helpMsg = new StringBuilder();
        return "";
    }


    /**
     * Reuturns some help information.
     * Current location message and a list of the
     * command words.
     */
    public String getCommandsMsg() {
        StringBuilder commandsMsg = new StringBuilder();
        commandsMsg.append(ANSI_GREEN + "[?]Info [!]Give Up [q]Quit" + terminalColor.reset());
        return commandsMsg.toString();
    }


    /* Caption UI elements */
    public String quitGameUI() {
        return ANSI_GREEN + captionUI("[q] THANKS YOU FOR PLAYING, QUITTING GAME...") + terminalColor.reset();
    }

    public String restartUI(boolean won) {
        if (won) {
            return ANSI_GREEN + captionUI("[◕‿◕] YOU WON, RESTARTING GAME...") + terminalColor.reset();
        } else {
            return ANSI_YELLOW + captionUI("[!] YOU GAVE UP, RESTARTING GAME...") + terminalColor.reset();
        }
    }

    public String incorrectUI() {
        return ANSI_RED + captionUI("[X] INCORRECT GUESS") + terminalColor.reset();
    }

    public String correctUI() {
        return ANSI_GREEN + captionUI("[+1 Point] CORRECT GUESS") + terminalColor.reset();
    }

    public static String captionUI(String msg) {
        StringBuilder sb = new StringBuilder();
        sb.append(drawCharLineH("▀", widthDefault));
        sb.append("\n");
        sb.append(borderText(centerText(msg)));
        sb.append(drawCharLineH("▄", widthDefault));
        return sb.toString();
    }

    /* UI Utilities*/

    private static String drawCharLineH(String pattern, int width) {
        return String.valueOf(pattern).repeat(Math.max(0, width));
    }

    private static String drawCharBorderV(String pattern, String text) {
        String[] contentSplit = text.split("\n");
        StringBuilder sb = new StringBuilder();

        for (String line : contentSplit) {
            sb.append(pattern).append(line).append(pattern).append("\n");
        }

        return sb.toString();
    }

    private static String borderText(String text, boolean borderOutside) {
        StringBuilder sb = new StringBuilder(text);
        if (!borderOutside) {
            sb.deleteCharAt(sb.length() - 1).deleteCharAt(0);
        }
        return drawCharBorderV("█", sb.toString());
    }

    private static String borderText(String text) {
        return borderText(text, false);
    }

    private static String embedText(int width, int padding, String pattern, String text) {
        if (text.length() > width) {
            return text;
        }

        int offset = (width - text.length()) % 2;
        int patternLen = (width - text.length() - padding * 2) / 2;

        StringBuilder sb = new StringBuilder();
        sb.append(drawCharLineH(pattern, patternLen + offset));
        if (padding > 0) {
            sb.append(drawCharLineH(" ", padding));
            sb.append(text);
            sb.append(drawCharLineH(" ", padding));
        } else {
            sb.append(text);
        }
        sb.append(drawCharLineH(pattern, patternLen));

        return sb.toString();
    }

    private static String centerText(int width, String text) {
        return embedText(width, 0, " ", text);
    }

    private static String centerText(String text) {
        return centerText(widthDefault, text);
    }

    private static String headingText(int width, String pattern, String text) {
        return embedText(width, 1, pattern, text);
    }

    private static String headingText(int width, String text) {
        return headingText(width, "▄", text);
    }

    private static String headingText(String text) {
        return headingText(widthDefault, "▄", text);
    }

    private static String headingText(String text, Boolean flipPattern) {
        if (flipPattern) {
            return headingText(widthDefault, "▀", text);
        }
        return headingText(headingText(text));
    }

    public static void main(String[] args) {
//        System.out.println(headingText(widthDefault + 9, ANSI_GREEN + "W" + ANSI_RESET));
//        System.out.println(headingText("W"));
//        System.out.println(headingText("WWW"));
//        System.out.println(headingText("WWWW"));
//        System.out.print(borderText(centerText("W")));
//        System.out.print(borderText(centerText("W")));
//        System.out.print(borderText(centerText("WW")));
//        System.out.print(borderText(centerText("WWW")));
//        System.out.print(borderText(centerText("WWWW")));
//        System.out.println(ANSI_RED);
//        System.out.print(captionUI(("[X] INCORRECT GUESS")));
//        System.out.println(ANSI_RESET);
        WordBoard wordBoard = new WordBoard("linuxwords.txt");
        TerminalColor terminalColor = new TerminalColor(ANSI_RESET, ANSI_RESET);
        MessageProvider messageProvider = new MessageProvider(terminalColor);
        messageProvider.update(10, 30, "hello", wordBoard);
        System.out.println(messageProvider.mainGameUI());
    }

//▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄ WORD BOARD INFO ▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄▄
//█                             WORD BOARgfdgfdgfdD INFO                             █
}
