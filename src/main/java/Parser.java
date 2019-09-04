public class Parser {
    private String[] commands;

    public Parser() {
    }

    public String[] parse(String command) {
        commands = command.split(" ");
        return commands;
    }
}
