import java.util.Scanner;
import java.util.ArrayList;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.FileWriter;
import java.io.BufferedWriter;

public class Duke {

    public static void main(String[] args) throws Exception {
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

        FileReader reader = new FileReader("/Users/jingrong/duke/duke.txt");
        BufferedReader bufferedReader = new BufferedReader(reader);

        String line = bufferedReader.readLine();
        while (! (line == null)) {
            String[] task = line.split(" , ");
            Task tsk;
            if (task[0].equals("T")) {
                tsk = new Todo(task[2]);
            } else if (task[0].equals("D")) {
                tsk = new Deadline(task[2], task[3]);
            } else {
                tsk = new Event(task[2], task[3]);
            }

            if (task[1].equals("y")) {
                tsk.mark();
            }

            list.add(tsk);
            line = bufferedReader.readLine();
        }

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

            } else if (commands[0].equals("delete")) {
                System.out.println("     Noted. I've removed this task:");
                int index = Integer.valueOf(commands[1]) - 1;
                System.out.println("       " + list.get(index).toString());
                list.remove(index);
                System.out.println(String.format("     Now you have %d tasks in the list.", list.size()));

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
                    if (commands.length == 1) {
                        System.out.println("     OOPS!!! The description of a todo cannot be empty.");
                        System.out.println("    ____________________________________________________________");
                        System.out.println();
                        command = scanner.nextLine();
                        continue;
                    } else {
                        task = new Todo(taskName);
                    }
                } else if (commands[0].equals("deadline")) {
                    if (commands.length == 1) {
                        System.out.println("     OOPS!!! The description of a deadline cannot be empty.");
                        System.out.println("    ____________________________________________________________");
                        System.out.println();
                        command = scanner.nextLine();
                        continue;
                    } else {
                        String[] details = taskName.split(" /by ");
                        task = new Deadline(details[0], details[1]);
                    }
                } else if (commands[0].equals("event")){
                    if (commands.length == 1) {
                        System.out.println("     OOPS!!! The description of an event cannot be empty.");
                        System.out.println("    ____________________________________________________________");
                        System.out.println();
                        command = scanner.nextLine();
                        continue;
                    } else {
                        String[] details = taskName.split(" /at ");
                        task = new Event(details[0], details[1]);
                    }
                } else {
                    System.out.println("     OOPS!!! I'm sorry, but I don't know what that means :-(");
                    System.out.println("    ____________________________________________________________");
                    System.out.println();
                    command = scanner.nextLine();
                    continue;
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

        FileWriter writer = new FileWriter("/Users/jingrong/duke/duke.txt", false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);
        for (Task item : list) {
            if (item instanceof Todo) {
                bufferedWriter.write(String.format("T , %s , %s", item.getMark(), item.getName()));
            } else if (item instanceof Deadline) {
                bufferedWriter.write(String.format("D , %s , %s , %s", item.getMark(), item.getName(), ((Deadline) item).getBy()));
            } else {
                bufferedWriter.write(String.format("D , %s , %s , %s", item.getMark(), item.getName(), ((Event) item).getAt()));
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();

        System.out.println("    ____________________________________________________________");
        System.out.println("     Bye. Hope to see you again soon!");
        System.out.println("    ____________________________________________________________");
    }
}
