import java.util.Scanner;

public class Ui {
    Scanner scanner;
    private boolean isExit;
    private Parser parser;

    public Ui() {
        scanner = new Scanner(System.in);
        isExit = false;
        parser = new Parser();
    }

    public void showLine() {
        System.out.println("    ____________________________________________________________");
    }

    public void showWelcome() {
        String logo = " ____        _        \n"
                + "|  _ \\ _   _| | _____ \n"
                + "| | | | | | | |/ / _ \\\n"
                + "| |_| | |_| |   <  __/\n"
                + "|____/ \\__,_|_|\\_\\___|\n";
        System.out.println("Hello from\n" + logo);
        showLine();
        System.out.println("     Hello! I'm Duke\n     What can I do for you?");
        showLine();
        System.out.println();
    }

    public void execute(TaskList tasks) {
        String command = scanner.nextLine();
        showLine();
        if (command.equals("bye")) {
            isExit = true;

        } else if (command.equals("list")) {
            System.out.println("     Here are the tasks in your list:");
            for (int i = 0; i < tasks.getTasks().size(); i++) {
                System.out.println(String.format("     %d.%s", i + 1, tasks.getTasks().get(i).toString()));
            }
            showLine();
            System.out.println();

        } else {
            String[] commands = parser.parse(command);
            if (commands[0].equals("delete")) {
                System.out.println("     Noted. I've removed this task:");
                int index = Integer.valueOf(commands[1]) - 1;
                System.out.println("       " + tasks.getTasks().get(index).toString());
                tasks.delete(index);
                System.out.println(String.format("     Now you have %d tasks in the list.", tasks.getTasks().size()));
                showLine();
                System.out.println();

            } else if (commands[0].equals("done")) {
                int index = Integer.valueOf(commands[1]) - 1;
                Task t = tasks.getTasks().get(index);
                tasks.done(index);
                System.out.println("     Nice! I've marked this task as done:");
                System.out.println("       " + t.toString());
                showLine();
                System.out.println();

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
                if (commands[0].equals("todo") || commands[0].equals("deadline") || commands[0].equals("event")) {
                    if (commands.length == 1) {
                        if (commands[0].equals("event")) {
                            System.out.println("     OOPS!!! The description of an event cannot be empty.");
                        } else {
                            System.out.println(String.format("     OOPS!!! The description of a %s cannot be empty.",
                                    commands[0]));

                        }
                        showLine();
                        System.out.println();

                    } else {
                        if (commands[0].equals("todo")) {
                            task = new Todo(taskName);

                        } else if (commands[0].equals("deadline")) {
                            String[] details = taskName.split(" /by ");
                            task = new Deadline(details[0], details[1]);

                        } else {
                            String[] details = taskName.split(" /at ");
                            task = new Event(details[0], details[1]);

                        }

                        tasks.add(task);
                        System.out.println("     Got it. I've added this task:");
                        System.out.println("       " + task.toString());
                        if (tasks.getTasks().size() == 1) {
                            System.out.println("     Now you have 1 task in the list.");

                        } else {
                            System.out.println(String.format("     Now you have %d tasks in the list.", tasks.getTasks()
                                    .size()));

                        }
                        showLine();
                        System.out.println();
                    }
                } else {
                    System.out.println("     OOPS!!! I'm sorry, but I don't know what that means :-(");
                    showLine();
                    System.out.println();

                }
            }
        }
    }

    public void showError(String error) {
        if (error.equals("load")) {
            System.out.println("     OOPS!!! The list of tasks cannot be loaded.");
        } else if (error.equals("filepath")) {
            System.out.println("     OOPS!!! There is something wrong with the filepath.");
        } else if (error.equals("store")) {
            System.out.println("     OOPS!!! There is something wrong with the file.");
        }
    }

    public boolean isExit() {
        return isExit;
    }

    public void exit() {
        System.out.println("     Bye. Hope to see you again soon!");
        showLine();
    }
}
