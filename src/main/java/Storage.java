import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.util.ArrayList;

/**
 * Encapsulates a Storage object to load and save tasks from and to file.
 */
public class Storage {
    private String filePath;
    private FileReader reader;
    private BufferedReader bufferedReader;
    private ArrayList<Task> tasks;

    /**
     * Creates a Storage object tagged with path of file, file reader, buffered reader, and list of tasks.
     *
     * @param filePath path of file for loading and saving of tasks.
     * @throws FileNotFoundException If file is not found at specified location.
     */
    public Storage(String filePath) throws FileNotFoundException {
        this.filePath = filePath;
        this.reader = new FileReader(this.filePath);
        this.bufferedReader = new BufferedReader(reader);
        this.tasks = new ArrayList<>();
    }

    /**
     * Returns ArrayList of tasks loaded from file.
     *
     * @return ArrayList of tasks.
     * @throws IOException If tasks failed to be retrieved.
     */
    public ArrayList<Task> load() throws IOException {
        String line = bufferedReader.readLine();
        while (! (line == null)) {
            String[] words = line.split(" , ");
            Task task;
            if (words[0].equals("T")) {
                task = new Todo(words[2]);
            } else if (words[0].equals("D")) {
                task = new Deadline(words[2], words[3]);
            } else {
                task = new Event(words[2], words[3]);
            }

            if (words[1].equals("y")) {
                task.setDone();
            }

            tasks.add(task);
            line = bufferedReader.readLine();
        }

        return tasks;
    }

    /**
     * Stores tasks in file.
     *
     * @throws IOException If tasks failed to be stored.
     */
    public void store() throws IOException {
        FileWriter writer = new FileWriter(this.filePath, false);
        BufferedWriter bufferedWriter = new BufferedWriter(writer);

        for (Task item : tasks) {
            if (item instanceof Todo) {
                bufferedWriter.write(String.format("T , %s , %s", item.isDone(), item.getName()));
            } else if (item instanceof Deadline) {
                bufferedWriter.write(String.format("D , %s , %s , %s", item.isDone(), item.getName(), ((Deadline) item)
                        .getBy()));
            } else {
                bufferedWriter.write(String.format("D , %s , %s , %s", item.isDone(), item.getName(), ((Event) item)
                        .getAt()));
            }
            bufferedWriter.newLine();
        }
        bufferedWriter.close();
    }
}
