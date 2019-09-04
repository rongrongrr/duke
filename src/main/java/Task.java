/**
 * Encapsulates a task to be stored in Duke.
 */
public abstract class Task {
    private String name;
    private boolean isDone;

    /**
     * Creates a Task object tagged with name and whether it is completed.
     *
     * @param name Name of task.
     */
    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    /**
     * Returns "y" or "n" based on completion of task.
     *
     * @return String "y" or "n".
     */
    public String isDone() {
        if (isDone) {
            return "y";
        } else {
            return "n";
        }
    }

    /**
     * Returns name of task.
     *
     * @return Name of task.
     */
    public String getName() {
        return name;
    }

    /**
     * Marks task as done.
     */
    public void setDone() {
        isDone = true;
    }

    /**
     * Overrides the original toString method.
     * Returns description of task as `[isDone] name`.
     *
     * @return Formatted description of task.
     */
    @Override
    public String toString() {
        return String.format("[%s] %s", isDone(), name);
    }
}
