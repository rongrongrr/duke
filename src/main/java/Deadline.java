import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Encapsulates a deadline to be stored in Duke.
 */
public class Deadline extends Task {
    private String name;
    private boolean done;
    private Date by;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");

    /**
     * Creates a Deadline object tagged with name, whether it is completed, and task deadline.
     *
     * @param name Name of event.
     * @param by Deadline by when task is due.
     */
    public Deadline(String name, String by) throws ParseException {
        super(name);
        this.by = format.parse(by);
    }

    /**
     * Returns name of deadline.
     *
     * @return Name of deadline.
     */
    public String getName() {
        return super.getName();
    }

    /**
     * Returns "y" or "n" based on completion of deadline.
     *
     * @return String "y" or "n".
     */
    public String isDone() {
        return super.isDone();
    }

    /**
     * Returns deadline of task.
     *
     * @return Deadline of task in String format.
     */
    public String getBy() {
        return format.format(by);
    }

    /**
     * Marks deadline as done.
     */
    public void setDone() {
        super.setDone();
    }

    /**
     * Overrides the original toString method.
     * Returns description of deadline as `[D][isDone] name (by: date)`.
     *
     * @return Formatted description of deadline.
     */
    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), format.format(by));
    }
}
