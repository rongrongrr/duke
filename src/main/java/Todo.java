public class Todo extends Task {
    private String name;
    private boolean done;

    public Todo(String name) {
        super(name);
    }

    public String getName() {
        return super.getName();
    }

    public String isDone() {
        return super.isDone();
    }

    public void setDone() {
        super.setDone();
    }

    @Override
    public String toString() {
        return String.format("[T]%s", super.toString());
    }
}
