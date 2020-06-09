import chestiiCuFisiere.StudentAccountCreator;
import chestiiCuFisiere.StudentCsvFileWriter;
import chestiiCuFisiere.StudentFileReader;
import chestiiCuFisiere.util.PasswordGenerator;
import chestiiCuFisiere.util.StudentEmailGenerator;
import clase.Employees;

import java.util.Scanner;

public class Tema {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        int input = kb.nextInt();
        //this is like, really shit but I'm too lazy to do it all pretty like.
        if (input == 2) {
            new StudentAccountCreator(
                    new StudentFileReader("resources/studenti.txt"),
                    new StudentCsvFileWriter("accounts.csv"),
                    new PasswordGenerator(),
                    new StudentEmailGenerator()
            ).generateStudentAccounts();
            return;
        } else if (input > 2 || input < 1) {
            StudentFileReader reader = new StudentFileReader("resources/studenti.txt");
            reader.read();
            System.out.println(
                    reader.getContent(students -> {
                        students.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()));
                    })
            );
            System.exit(0);
        }
        new Employees().showEmployeeData(kb.nextInt());


    }
}
