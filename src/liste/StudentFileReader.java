package liste;

import liste.model.Student;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class StudentFileReader extends ListFileReader<Student> {

    public StudentFileReader(String filePath) {
        super(filePath);
    }

    @Override
    //In an ideal world it wouldn't need to be synchronized but /shrug
    public synchronized void read() {
        content.clear();
        try {
            Files.lines(Paths.get(filePath))
                    .forEach(line -> {
                        String[] components = line.split(" ");
                        content.add(new Student(
                                components[0],
                                components[1],
                                Integer.parseInt(components[2]),
                                components[3],
                                Long.parseLong(components[4]),
                                Float.parseFloat(components[5])));
                    });
        } catch (IOException e) {
            //idk probably send to an exception handler or something. Too lazy to do it, we don't even have UI lol
            e.printStackTrace();
        }

    }
}
