package chestiiCuFisiere;

import chestiiCuFisiere.model.Student;
import chestiiCuFisiere.model.StudentAccountEntry;
import chestiiCuFisiere.util.PasswordGenerator;
import chestiiCuFisiere.util.StudentEmailGenerator;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

public class StudentAccountCreator {

    private final ListFileReader<Student> studentListFileReader;
    private final StudentCsvFileWriter csvFileWriter;
    private final PasswordGenerator passwordGenerator;
    private final StudentEmailGenerator emailGenerator;

    public StudentAccountCreator(ListFileReader<Student> studentListFIleReader,
                                 StudentCsvFileWriter csvFileWriter,
                                 PasswordGenerator passwordGenerator,
                                 StudentEmailGenerator emailGenerator) {
        this.studentListFileReader = studentListFIleReader;
        this.csvFileWriter = csvFileWriter;
        this.passwordGenerator = passwordGenerator;
        this.emailGenerator = emailGenerator;
    }

    public void generateStudentAccounts() {
        try {
            studentListFileReader.read();
            csvFileWriter.writeToFile(generateEntries(studentListFileReader.getContent()));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    private List<StudentAccountEntry> generateEntries(List<Student> students) {
        return students.stream()
                .map(student -> new StudentAccountEntry(
                        student.getName(),
                        student.getFirstName(),
                        emailGenerator.generateStudentEmail(student),
                        passwordGenerator.generateRandomPassword(8)
                )).collect(Collectors.toList());
    }
}
