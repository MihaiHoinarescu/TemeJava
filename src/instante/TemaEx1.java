package instante;

import agenda.PhoneBook;
import agenda.io.ContactFileReader;
import liste.StudentAccountCreator;
import liste.StudentCsvFileWriter;
import liste.StudentFileReader;
import liste.util.PasswordGenerator;
import liste.util.StudentEmailGenerator;
import clase.Employees;

import java.util.Scanner;

public class TemaEx1 {

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
        } else if (input == 3) {
            PhoneBook phoneBook = new PhoneBook(new ContactFileReader("resources/agendaTelefonica.txt"));
            phoneBook.init();
            System.out.println("Pick a contact.");

            while (true) {
                String name = kb.nextLine();
                if (name.isEmpty()) {
                    continue;
                }
                if (name.equals("exit")) {
                    System.exit(0);
                }
                String number = phoneBook.getContactNumber(name);
                if (number.isEmpty()) {
                    System.out.println("No contact found with name " + name);
                    continue;
                }

                System.out.println(number);
            }

        } else if (input > 3 || input < 1) {
            StudentFileReader reader = new StudentFileReader("resources/studenti.txt");
            reader.read();
            System.out.println(
                    reader.getContent(
                            students -> students.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                    )
            );
            System.exit(0);
        }
        new Employees().showEmployeeData(kb.nextInt());
    }
}
