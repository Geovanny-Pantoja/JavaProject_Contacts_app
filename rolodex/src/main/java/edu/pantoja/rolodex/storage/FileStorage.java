/*******
* Name: Geovanny Pantoja
* date: 26 March 2026
* purpose of the class: Load and save serialized entities to a file; implements Storage interface.
* demonstrates file handling and list management for persistence.
*/
package edu.pantoja.rolodex.storage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileStorage<T> implements Storage<T> {

    private final String FILE_PATH = "contacts.txt";
    private final EntitySerializer<T> serializer;

    public FileStorage(EntitySerializer<T> serializer) {
        this.serializer = serializer;
    }

    @Override
    public List<T> loadData() {
        List<T> entities = new ArrayList<>();
        File filePath = new File(FILE_PATH);
        if (!filePath.exists()) {
            return entities; // Return empty list if file doesn't exist
        }
        try (Scanner scanner = new Scanner(filePath)) {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                T entity = serializer.deserialize(line);
                entities.add(entity);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return entities;
    }

    @Override
    public void saveData(List<T> entities)  {
        try (PrintWriter writer = new PrintWriter(new FileWriter(FILE_PATH))) {
            for (T entity : entities) {
                String serialized = serializer.serialize(entity);
                writer.println(serialized);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
   


}
