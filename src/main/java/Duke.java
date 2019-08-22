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
                System.out.println("       " + t.toString());

            } else if (command.equals("list")) {
                System.out.println("     Here are the tasks in your list:");
                for (int i = 0; i < list.size(); i++) {
                    System.out.println(String.format("     %d.%s", i + 1, list.get(i).toString()));
                }

            } else {
                String taskName = "";
                for (int j = 1; j < commands.length; j++) {
                    if (j != commands.length - 1) {
                        taskName += commands[j] + " ";
                    } else {
                        taskName += commands[j];
                    }
                }
                Task task;

                if (commands[0].equals("todo")) {
                    task = new Todo(taskName);
                } else if (commands[0].equals("deadline")) {
                    String[] details = taskName.split(" /by ");
                    task = new Deadline(details[0], details[1]);
                } else {
                    String[] details = taskName.split(" /at ");
                    task = new Event(details[0], details[1]);
                }

                list.add(task);
                System.out.println("     Got it. I've added this task:");
                System.out.println("       " + task.toString());
                if (list.size() == 1) {
                    System.out.println("     Now you have 1 task in the list.");
                } else {
                    System.out.println(String.format("     Now you have %d tasks in the list.", list.size()));
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
