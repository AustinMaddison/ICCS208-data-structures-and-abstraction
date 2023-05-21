package game.color;

public class TerminalColor {

    private String textColorDefault;
    private String backgroundColorDefault;

    /**
     * Configures and applies default color for terminal game.
     * @param textColorDefault Set default text color of terminal
     * @param backgroundColorDefault Set default text color background of terminal
     */
    public TerminalColor(String textColorDefault, String backgroundColorDefault) {
        this.textColorDefault = textColorDefault;
        this.backgroundColorDefault = backgroundColorDefault;

        System.out.print(textColorDefault + backgroundColorDefault);  // Set default colors
    }

    /**
     * Resets terminal colors to default.
     */
    public String reset() {
        return textColorDefault + backgroundColorDefault;  // Set default colors
    }

    // Text Color
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[90m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[92m";
    public static final String ANSI_YELLOW = "\u001B[93m";
    public static final String ANSI_BLUE = "\u001B[94m";
    public static final String ANSI_PURPLE = "\u001B[95m";
    public static final String ANSI_CYAN = "\u001B[96m";
    public static final String ANSI_WHITE = "\u001B[97m";

    // Background Color
    public static final String ANSI_BLACK_BACKGROUND = "\u001B[40m";
    public static final String ANSI_RED_BACKGROUND = "\u001B[41m";
    public static final String ANSI_GREEN_BACKGROUND = "\u001B[42m";
    public static final String ANSI_YELLOW_BACKGROUND = "\u001B[43m";
    public static final String ANSI_BLUE_BACKGROUND = "\u001B[44m";
    public static final String ANSI_PURPLE_BACKGROUND = "\u001B[45m";
    public static final String ANSI_CYAN_BACKGROUND = "\u001B[46m";
    public static final String ANSI_WHITE_BACKGROUND = "\u001B[47m";
        

}
