package instante;

import agenda.PhoneBook;
import agenda.io.ContactFileReader;

import java.util.Scanner;

public class TemaEx4 {

    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
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
    }
}
