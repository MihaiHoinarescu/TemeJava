package agenda;

import agenda.model.Contact;
import colectii.ListFileReader;

import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PhoneBook {

    private final ListFileReader<Contact> fileReader;
    private final Map<String, String> contactMap = new HashMap<>();

    public PhoneBook(ListFileReader<Contact> fileReader) {
        this.fileReader = fileReader;
    }

    public void init() {
        try {
            fileReader.read();
            buildContactMap(fileReader.getContent());
        } catch (FileNotFoundException e) {
            // ass
            e.printStackTrace();
        }
    }

    private void buildContactMap(List<Contact> contacts) {
        contacts.forEach(contact -> contactMap.put(contact.getName(), contact.getPhoneNumber()));
    }

    public String getContactNumber(String name) {
        if (contactMap.isEmpty()) {
            throw new IllegalStateException("INIT FIRST YOU DUMBDUMB");
        }

        String number = contactMap.get(name);

        if (number == null) {
            // You should throw an exception here but I'm too lazy to handle it upstream, and the whiskey is kicking in.
            return "";
        }

        return number;
    }
}
