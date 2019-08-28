public abstract class Task {
    private String name;
    private boolean done;

    public Task(String name) {
        this.name = name;
        this.done = false;
    }

    public String getMark() {
        if (done) {
            return "y";
        } else {
            return "n";
        }
    }

    public String getName() {
        return name;
    }

    public void mark() {
        done = true;
    }

    @Override
    public String toString() {
        String mark;
        if (done) {
            mark = "y";
        } else {
            mark = "n";
        }

        return String.format("[%s] %s", mark, name);
    }
}
