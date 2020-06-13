package instante;

import colectii.StudentAccountCreator;
import colectii.StudentCsvFileWriter;
import colectii.StudentFileReader;
import colectii.util.PasswordGenerator;
import colectii.util.StudentEmailGenerator;

public class TemaEx2 {

    public static void main(String[] args) {
        new StudentAccountCreator(
                new StudentFileReader("resources/studenti.txt"),
                new StudentCsvFileWriter("accounts.csv"),
                new PasswordGenerator(),
                new StudentEmailGenerator()
        ).generateStudentAccounts();
    }
}
