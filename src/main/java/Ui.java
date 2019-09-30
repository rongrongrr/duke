import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Encapsulates a Ui to deal with user interactions.
 */
public class Ui {
    Scanner scanner;
    private boolean isExit;
    private Parser parser;
    private StringBuilder string;
    private TaskList undoneTasks;
    private int meowCount;
    private int purrCount;

    /**
     * Creates a Ui object tagged with scanner, whether the program is exited, and parser.
     */
    public Ui() {
        scanner = new Scanner(System.in);
        isExit = false;
        parser = new Parser();
        undoneTasks = new TaskList();
        meowCount = 0;
        purrCount = 0;
    }

    /**
     * Displays a welcome message.
     */
    public String showWelcome() {
        return "Meow! I'm Duke :3\nWhat can I do for you nya?\nType 'help' for more info nya nya!";
    }

    /**
     * Executes the given user commands.
     *
     * @param tasks Tasks to mark as completed, add to, delete, or view based on user commands.
     */
    public String execute(String command, TaskList tasks) throws ParseException {
        string = new StringBuilder();
        if (!command.equals("undo")) {
            undoneTasks = new TaskList();
            for (Task task : tasks.getTasks()) {
                Task addTask;
                if (task instanceof Todo) {
                    addTask = new Todo(task.getName());
                } else if (task instanceof Event) {
                    addTask = new Event(task.getName(), ((Event) task).getAt());
                } else {
                    addTask = new Deadline(task.getName(), ((Deadline) task).getBy());
                }
                if (task.isDone().equals("y")) {
                    addTask.setDone();
                }
                undoneTasks.add(addTask);
            }
        }

        switch (command) {
        case "help":
            string.append("Here are the commands available nya :3\n");
            string.append("- list -> returns the current list of tasks nya\n" +
                    "\n- todo [name] -> creates a Todo nya\n" +
                    "\n- deadline [name] /by [dd/mm/yyyy hhmm] -> creates a Deadline nya\n" +
                    "\n- event [name] /at [dd/mm/yyyy hhmm] -> creates an Event nya\n" +
                    "\n- find [keyword] -> returns tasks matching the keyword given nya\n" +
                    "\n- done [index] -> marks the task at the index as done nya\n" +
                    "\n- delete [index] -> deletes the task at the index nya\n" +
                    "\n- undo -> undoes your previous action nya\n" +
                    "\n- bye -> saves your task list and ends the program nya~ bye bye!\n" +
                    "\nYou can also type 'more help' for other interesting commands nya!");
            break;

        case "more help":
            string.append("You can also try these commands nya~\n" +
                    "- meow -> meow?\n" +
                    "\n- pet -> meow meow?\n");
            break;

        case "bye":
            isExit = true;
            break;
        case "list":
            string.append("Here are the tasks in your list nya:\n");
            for (int i = 0; i < tasks.getTasks().size(); i++) {
                string.append(String.format("     %d.%s\n", i + 1, tasks.getTasks().get(i).toString()));
            }
            break;
        case "meow":
            meowCount += 1;
            if (meowCount >= 3) {
                string.append("Nya!!! Give me a useful command!! >:3");
                meowCount = 0;
            } else {
                for (int i = 0; i < meowCount; i++) {
                    string.append("Meow~~~ ");
                }
            }
            break;
        case "pet":
            purrCount += 1;
            if (purrCount == 3) {
                string.append("Nya!!! Stop petting or I will scratch you *hiss* >:3");
            } else if (purrCount > 3) {
                string.append("HISS!!! *scratch* *angry cat noises*");
                purrCount = 0;
            } else {
                for (int i = 0; i < purrCount; i++) {
                    string.append("Purr~~~ ");
                }
            }
            break;
        case "":
            string.append("Meow? Please say something!");
            break;
        case "undo":
            string.append("Meow! Noted~ Your previous command has been undone. Here are the tasks in your list nya:\n");
            while(!tasks.getTasks().isEmpty()) {
                tasks.delete(0);
            }
            for (Task task : undoneTasks.getTasks()) {
                tasks.add(task);
            }

            for (int i = 0; i < tasks.getTasks().size(); i++) {
                string.append(String.format("     %d.%s\n", i + 1, tasks.getTasks().get(i).toString()));
            }
            break;
        default:
            String[] commands = parser.parse(command);
            String com = commands[0];
            int index;
            switch (com) {
            case "delete":
                if (commands.length < 2) {
                    string.append("Nya? There is no index given nya *confused cat noises");
                } else if (commands.length != 2) {
                    string.append("Nya? Your delete instruction is wrong nya *confused cat noises");
                } else {
                    try {
                        index = Integer.valueOf(commands[1]) - 1;
                        if (tasks.getTasks().isEmpty()) {
                            string.append("Nya? There is nothing to remove nya *confused cat noises*");
                        } else if (index >= tasks.getTasks().size() || index < 0) {
                            string.append(String.format("Nya? There are no tasks at (%d) nya *confused cat noises*",
                                    index + 1));
                        } else {
                            string.append("Meow! Noted~ I've removed this task nya:\n");
                            Task deletedTask = tasks.getTasks().get(index);
                            string.append("       " + deletedTask.toString() + "\n");
                            tasks.delete(index);
                            boolean isMatching = false;
                            for (Task task : tasks.getTasks()) {
                                if (deletedTask.equals(task)) {
                                    isMatching = true;
                                }
                            }
                            assert isMatching : "the task at this index should have been deleted nya";
                            string.append(String.format("Now you have %d tasks in the list nya~",
                                    tasks.getTasks().size()));
                        }
                    } catch (NumberFormatException e) {
                        string.append("Nya? The index given is not a number nya *confused cat noises");
                    }
                }
                break;
            case "done":
                if (commands.length < 2) {
                    string.append("Nya? There is no index given nya *confused cat noises");
                } else if (commands.length != 2) {
                    string.append("Nya? Your done instruction is wrong nya *confused cat noises");
                } else {
                    try {
                        index = Integer.valueOf(commands[1]) - 1;
                        if (index >= tasks.getTasks().size() || index < 0) {
                            string.append(String.format("Nya? There are no tasks at (%d) nya *confused cat noises*",
                                    index + 1));
                        } else {
                            Task t = tasks.getTasks().get(index);
                            if (t.isDone().equals("y")) {
                                string.append("Nya? The task is already done nya *confused cat noises*");
                            } else {
                                tasks.done(index);
                                String isDone = t.isDone();
                                assert isDone.equals("y") : "the task should be marked done nya";
                                string.append("Nice nya! I've marked this task as done nya:\n");
                                string.append("       " + t.toString() + "\n");
                            }
                        }
                    } catch (NumberFormatException e) {
                        string.append("Nya? The index given is not a number nya *confused cat noises");
                    }
                }
                break;
            case "find":
                if (commands.length == 1) {
                    string.append("Nya? The search criteria cannot be empty nya *confused cat noises*");
                } else if (commands.length > 2) {
                    string.append("Nya? Your search instruction is wrong nya *confused cat noises*");
                } else {
                    ArrayList<Task> results = new ArrayList<>();
                    for (Task task : tasks.getTasks()) {
                        if (task.getName().contains(commands[1])) {
                            results.add(task);
                        }
                    }
                    if (results.isEmpty()) {
                        string.append("There were no matching tasks nya.");
                    } else {
                        string.append("Here are the matching tasks in your list nya:\n");
                        for (int i = 0; i < results.size(); i++) {
                            string.append(String.format("     %d.%s\n", i + 1, results.get(i).toString()));
                        }
                    }
                }
                break;
            default:
                String taskName = "";
                for (int j = 1; j < commands.length; j++) {
                    if (j != commands.length - 1) {
                        taskName += commands[j] + " ";
                    } else {
                        taskName += commands[j];
                    }
                }

                Task task;
                boolean isError = false;
                if (commands[0].equals("todo") || commands[0].equals("deadline") || commands[0].equals("event")) {
                    if (commands.length == 1) {
                        if (commands[0].equals("event")) {
                            string.append("Nya? The description of an event cannot be empty nya *confused cat noises*");
                        } else {
                            string.append(String.format("Nya? The description of a %s cannot be empty nya " +
                                            "*confused cat noises*", commands[0]));
                        }
                    } else {
                        if (commands[0].equals("todo")) {
                            task = new Todo(taskName);
                        } else if (commands[0].equals("deadline")) {
                            String[] details = taskName.split(" /by ");
                            if (details.length != 2) {
                                string.append("Nya? There is no deadline given nya *confused cat noises*");
                                isError = true;
                                task = new Deadline("dummy", "10/10/1000 1000");
                            } else {
                                try {
                                    task = new Deadline(details[0], details[1]);
                                } catch (ParseException e) {
                                    string.append("Nya? The format of the deadline is wrong nya *confused cat noises*");
                                    isError = true;
                                    task = new Deadline("dummy", "10/10/1000 1000");
                                }
                            }
                        } else {
                            String[] details = taskName.split(" /at ");
                            if (details.length != 2) {
                                string.append("Nya? There is no event date given nya *confused cat noises*");
                                isError = true;
                                task = new Event("dummy", "10/10/1000 1000");
                            } else {
                                try {
                                    task = new Event(details[0], details[1]);
                                } catch (ParseException e) {
                                    string.append("Nya? The format of the event is wrong nya *confused cat noises*");
                                    isError = true;
                                    task = new Event("dummy", "10/10/1000 1000");
                                }
                            }
                        }

                        if(!isError) {
                            int taskSize = tasks.getTasks().size();
                            tasks.add(task);
                            string.append("Meow! Got it~ I've added this task nya:\n");
                            string.append("       " + task.toString() + "\n");
                            if (tasks.getTasks().size() == 1) {
                                string.append("Now you have 1 task in the list nya~\n");

                            } else {
                                string.append(String.format("Now you have %d tasks in the list nya~\n", tasks.getTasks()
                                        .size()));
                            }

                            int newTaskSize = tasks.getTasks().size();
                            assert newTaskSize == taskSize + 1 : "the list should have increased by 1 task nya";
                        }
                    }

                } else {
                    string.append("Nya? I'm sorry, but I don't know what that means nya :,3\n");
                }
            }
        }
        return string.toString();
    }

    /**
     * Displays error messages.
     *
     * @param error Name of error.
     */
    public void showError(String error) {
        if (error.equals("load")) {
            string.append("Nya? The list of tasks cannot be loaded nya *confused cat noises*");
        } else if (error.equals("filepath")) {
            string.append("Nya? There is something wrong with the filepath nya *confused cat noises*");
        } else if (error.equals("store")) {
            string.append("Nya? There is something wrong with the file nya *confused cat noises*");
        }
    }

    /**
     * Returns if program is to be exited.
     *
     * @return Boolean depending on whether program is to be exited.
     */
    public boolean isExit() {
        return isExit;
    }

    /**
     * Shows exit message for stopping program.
     */
    public String exit() {
        return "Bye bye! Hope to see you again soon nya! :3 :3 :3\n";
    }
}
