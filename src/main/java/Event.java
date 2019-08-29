import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Event extends Task {
    private String name;
    private boolean done;
    private Date at;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");

    public Event(String name, String at) {
        super(name);
        try {
            this.at = format.parse(at);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getAt() {
        return format.format(at);
    }

    public void mark() {
        super.mark();
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), format.format(at));
    }
}
