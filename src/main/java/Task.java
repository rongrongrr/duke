public abstract class Task {
    private String name;
    private boolean isDone;

    public Task(String name) {
        this.name = name;
        this.isDone = false;
    }

    public String isDone() {
        if (isDone) {
            return "y";
        } else {
            return "n";
        }
    }

    public String getName() {
        return name;
    }

    public void setDone() {
        isDone = true;
    }

    @Override
    public String toString() {
        return String.format("[%s] %s", isDone(), name);
    }
}
