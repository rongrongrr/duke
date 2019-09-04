import java.io.FileNotFoundException;
import java.io.IOException;

public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    public Duke(String filePath) {
        ui = new Ui();
        try {
            storage = new Storage(filePath);
        } catch (FileNotFoundException e) {
            ui.showError("filepath");
            return;
        }
        try {
            tasks = new TaskList(storage.load());
        } catch (IOException e) {
            ui.showError("load");
            tasks = new TaskList();
        }
    }

    public void run() {
        ui.showWelcome();
        boolean isExit = false;
        while (!isExit) {
            ui.execute(tasks);
            isExit = ui.isExit();
        }

        try {
            storage.store();
        } catch (IOException e) {
            ui.showError("store");
        }

        ui.exit();
    }

    public static void main(String[] args) {
        new Duke("/Users/jingrong/duke/duke.txt").run();
    }
}
