package instante;

import clase.Employees;

import java.util.Scanner;

public class TemaEx1 {

    public static void main(String[] args) {

        Scanner kb = new Scanner(System.in);
        new Employees().showEmployeeData(kb.nextInt());
    }
}
