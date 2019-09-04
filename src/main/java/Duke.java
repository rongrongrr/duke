import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Encapsulates a Duke object for the execution of the Duke program.
 */
public class Duke {

    private Storage storage;
    private TaskList tasks;
    private Ui ui;

    /**
     * Creates a Duke object tagged with ui, storage and list of tasks.
     *
     * @param filePath path of file to be used as storage.
     */
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

    /**
     * Runs the Duke program.
     */
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
