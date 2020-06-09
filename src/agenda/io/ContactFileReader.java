package agenda.io;

import agenda.model.Contact;
import chestiiCuFisiere.ListFileReader;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ContactFileReader extends ListFileReader<Contact> {

    public ContactFileReader(String filePath) {
        super(filePath);
    }

    @Override
    public void read() {
        content.clear();
        try {
            Files.lines(Paths.get(filePath))
                    .forEach(line -> {
                        String[] components = line.split(", ");
                        content.add(new Contact(
                                components[0],
                                components[1]));
                    });
        } catch (IOException e) {
            // Scream really loud
            e.printStackTrace();
        }
    }
}
