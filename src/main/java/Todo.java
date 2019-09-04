/**
 * Encapsulates a todo to be stored in Duke.
 */
public class Todo extends Task {
    private String name;
    private boolean done;

    /**
     * Creates a Todo object tagged with name and whether it is completed.
     *
     * @param name Name of todo.
     */
    public Todo(String name) {
        super(name);
    }

    /**
     * Returns name of todo.
     *
     * @return Name of todo.
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Returns "y" or "n" based on completion of todo.
     *
     * @return String "y" or "n".
     */
    public String isDone() {
        return super.isDone();
    }

    /**
     * Marks todo as done.
     */
    public void setDone() {
        super.setDone();
    }

    /**
     * Overrides the original toString method.
     * Returns description of todo as `[T][isDone] name`.
     *
     * @return Formatted description of todo.
     */
    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
