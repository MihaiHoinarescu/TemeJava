package instante;

import colectii.StudentFileReader;

public class TemaEx3 {

    public static void main(String[] args) {
        StudentFileReader reader = new StudentFileReader("resources/studenti.txt");
        reader.read();
        System.out.println(
                reader.getContent(
                        students -> students.sort((o1, o2) -> o1.getName().compareToIgnoreCase(o2.getName()))
                )
        );
    }
}
