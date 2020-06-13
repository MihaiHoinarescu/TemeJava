package colectii.model;

public class StudentAccountEntry {

    private final String name;
    private final String firstName;
    private final String email;
    private final String tempPassword;

    public StudentAccountEntry(String name, String firstName, String email, String tempPassword) {
        this.name = name;
        this.firstName = firstName;
        this.email = email;
        this.tempPassword = tempPassword;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getEmail() {
        return email;
    }

    public String getTempPassword() {
        return tempPassword;
    }

}
