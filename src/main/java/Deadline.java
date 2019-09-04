import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.Date;

public class Deadline extends Task {
    private String name;
    private boolean done;
    private Date by;
    private SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy kkmm");

    public Deadline(String name, String by) {
        super(name);
        try {
            this.by = format.parse(by);
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

    public String getBy() {
        return format.format(by);
    }

    public void setDone() {
        super.setDone();
    }

    @Override
    public String toString() {
        return String.format("[D]%s (by: %s)", super.toString(), format.format(by));
    }
}
