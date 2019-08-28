public class Event extends Task {
    private String name;
    private boolean done;
    private String at;

    public Event(String name, String at) {
        super(name);
        this.at = at;
    }

    public String getAt() {
        return at;
    }

    public void mark() {
        super.mark();
    }

    @Override
    public String toString() {
        return String.format("[E]%s (at: %s)", super.toString(), at);
    }
}
