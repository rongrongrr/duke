public class Task {
    private String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String getName() {
        return name;
    }

    public boolean getDone() {
        return done;
    }

    public String getMark() {
        if(done) {
            return "[y]";
        } else {
            return "[n]";
        }
    }

    public void mark() {
        done = true;
    }
}
