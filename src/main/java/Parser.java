/**
 * Encapsulates a parser used to understand user commands.
 */
public class Parser {
    private String[] commands;

    /**
     * Creates a Parser object.
     */
    public Parser() {
    }

    /**
     * Returns user commands parsed as a String array.
     *
     * @param command Command from user input.
     * @return String array of split commands.
     */
    public String[] parse(String command) {
        commands = command.split(" ");
        return commands;
    }
}
