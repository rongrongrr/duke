import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;

public class Deadline extends Task {
    private String name;
    private boolean done;
    private Date by;

    SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");

    public Deadline(String name, String by) {
        super(name);
        try {
            this.by = format.parse(by);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }

    public String getBy() {
        return format.format(by);
    }

    public void mark() {
        super.mark();
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), format.format(by));
    }
}
