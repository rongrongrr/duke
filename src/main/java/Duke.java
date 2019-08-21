import java.util.Scanner;
import java.util.ArrayList;

public class Duke {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);

        System.out.println("    ____________________________________________________________");
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        System.out.println("    ____________________________________________________________");
        System.out.println();

        String command = scanner.nextLine();
        ArrayList<String> list = new ArrayList<>();

        while(!command.equals("bye")) {
            System.out.println("    ____________________________________________________________");
            if (!command.equals("list")) {
                list.add(command);
                System.out.println("     added: " + command);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d. %s", i + 1, list.get(i)));
                }
            }

            System.out.println("    ____________________________________________________________");
            System.out.println();
            command = scanner.nextLine();
        }

        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
