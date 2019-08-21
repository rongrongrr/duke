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
        ArrayList<Task> list = new ArrayList<>();

        while(!command.equals("bye")) {
            System.out.println("    ____________________________________________________________");
            String[] commands = command.split(" ");
            if (commands[0].equals("done")) {
                Task t = list.get(Integer.valueOf(commands[1]) - 1);
                t.mark();
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println(String.format("       %s %s", t.getMark(), t.getName()));

            } else if (command.equals("list")) {
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d.%s %s", i + 1, list.get(i).getMark(), list.get(i).getName()));
                }

            } else {
                Task task = new Task(command);
                list.add(task);
                System.out.println("     added: " + task.getName());

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
