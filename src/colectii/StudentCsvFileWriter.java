package colectii;

import colectii.model.StudentAccountEntry;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.List;

public class StudentCsvFileWriter {

    private final String OUTPUT_DIR = "outputs";
    private final String filePath;

    public StudentCsvFileWriter(String filePath) {
        this.filePath = filePath;
    }

    public synchronized void writeToFile(List<StudentAccountEntry> entries) {
        File outputFile = new File(OUTPUT_DIR + "/" + filePath);
        try (PrintWriter writer = new PrintWriter(outputFile)) {
            entries.stream()
                    .map(this::generateCSVEntry)
                    .forEach(writer::println);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }


    private String generateCSVEntry(StudentAccountEntry entry) {
        return entry.getName() +
                "," +
                entry.getFirstName() +
                "," +
                entry.getEmail() +
                "," +
                entry.getTempPassword();
    }
}
