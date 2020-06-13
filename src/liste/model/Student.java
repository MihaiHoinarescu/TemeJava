package liste.model;

import java.util.Objects;

public class Student {

    private final String name;
    private final String firstName;
    private final int year;
    private final String group;
    private final long studentCode;
    private final float grade;

    public Student(String name, String firstName, int year, String group, long studentCode, float grade) {
        this.name = name;
        this.firstName = firstName;
        this.year = year;
        this.group = group;
        this.studentCode = studentCode;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    public int getYear() {
        return year;
    }

    public String getGroup() {
        return group;
    }

    public long getStudentCode() {
        return studentCode;
    }

    public float getGrade() {
        return grade;
    }

    // No need for setters, I want this to be immutable.


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Student)) return false;
        Student student = (Student) o;
        return year == student.year &&
                studentCode == student.studentCode &&
                Float.compare(student.grade, grade) == 0 &&
                Objects.equals(name, student.name) &&
                Objects.equals(firstName, student.firstName) &&
                Objects.equals(group, student.group);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, year, group, studentCode, grade);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", year=" + year +
                ", group='" + group + '\'' +
                ", studentCode=" + studentCode +
                ", grade=" + grade +
                '}';
    }
}
