public class Todo extends Task {
    private String name;
    private boolean done;

    public Todo(String name) {
        super(name);
    }

    public void mark() {
        super.mark();
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
