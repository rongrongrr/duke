import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

/**
 * Encapsulates an event to be stored in Duke.
 */
public class Event extends Task {
    private String name;
    private boolean done;
    private Date at;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");

    /**
     * Creates an Event object tagged with name, whether it is completed, and event time.
     *
     * @param name Name of event.
     * @param at Date of event.
     */
    public Event(String name, String at) throws ParseException {
        super(name);
        this.at = format.parse(at);
    }

    public String getName() {
        return super.getName();
    }

    /**
     * Returns "y" or "n" based on completion of event.
     *
     * @return String "y" or "n".
     */
    public String isDone() {
        return super.isDone();
    }

    /**
     * Returns date of event.
     *
     * @return Date of event in String format.
     */
    public String getAt() {
        return format.format(at);
    }

    /**
     * Marks event as done.
     */
    public void setDone() {
        super.setDone();
    }

    /**
     * Overrides the original toString method.
     * Returns description of event as `[E][isDone] name (at: date)`.
     *
     * @return Formatted description of event.
     */
    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), format.format(at));
    }
}
