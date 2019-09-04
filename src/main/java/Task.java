/**
 * Encapsulates a task to be stored in Duke.
 */
public abstract class Task {
    private String name;
    private boolean done;

    /**
     * Creates a Task object tagged with name and whether it is completed.
     *
     * @param name Name of task.
     */
    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    /**
     * Returns "y" or "n" based on completeness of task.
     *
     * @return String "y" or "n".
     */
    public String getMark() {
        if (done) {
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
    public void mark() {
        done = true;
    }

    /**
     * Overrides the original toString method.
     * Returns description of task as `[isDone] name`.
     *
     * @return Formatted description of task.
     */
    @Override
    public String toString() {
        String mark;
        if (done) {
            mark = "y";
        } else {
            mark = "n";
        }

        return String.format("[%s] %s", mark, name);
    }
}
