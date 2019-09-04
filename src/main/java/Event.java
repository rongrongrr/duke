import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Event extends Task {
    private String name;
    private boolean done;
    private Date at;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");

    public Event(String name, String at) {
        super(name);
        try {
            this.at = format.parse(at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getName() {
        return super.getName();
    }

    public String isDone() {
        return super.isDone();
    }

    public String getAt() {
        return format.format(at);
    }

    public void setDone() {
        super.setDone();
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), format.format(at));
    }
}
