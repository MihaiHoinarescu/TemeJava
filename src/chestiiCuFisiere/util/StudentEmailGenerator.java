package chestiiCuFisiere.util;

import chestiiCuFisiere.model.Student;

public class StudentEmailGenerator {

    public String generateStudentEmail(Student student) {
        return student.getName() + "." + student.getFirstName() + "@s.utm.ro";
    }
}
