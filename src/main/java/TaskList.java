import java.util.ArrayList;

/**
 * Encapsulates a list for storing tasks in Duke.
 */
public class TaskList {
    private ArrayList<Task> tasks;

    /**
     * Creates a TaskList object tagged with an ArrayList of tasks.
     *
     * @param tasks ArrayList of Task objects.
     */
    public TaskList(ArrayList<Task> tasks) {
        this.tasks = tasks;
    }

    /**
     * Creates an empty TaskList with no tasks.
     */
    public TaskList() {
        this.tasks = new ArrayList<>();
    }

    /**
     * Adds task to list of tasks.
     * Task is added to back of the current list.
     *
     * @param task Task to be added into the list.
     */
    public void add(Task task) {
        tasks.add(task);
    }

    /**
     * Deletes the task at the corresponding index in the list.
     *
     * @param index Index of task to be deleted from list.
     */
    public void delete(int index) {
        tasks.remove(index);
    }

    /**
     * Marks task with corresponding index as completed.
     *
     * @param index Index of tasks to be marked completed in list.
     */
    public void done(int index) {
        tasks.get(index).setDone();
    }

    /**
     * Retrieves tasks available in list.
     *
     * @return tasks ArrayList of tasks.
     */
    public ArrayList<Task> getTasks() {
        return tasks;
    }
}
