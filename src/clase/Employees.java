package clase;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Employees {

    public static int EMPLOYEE_TSA = 0;
    public static int EMPLOYEE_PROFESSOR = 1;

    private final AngajatUTM[] employees = {
            new CadruDidactic("Baluta", 2000, 10, Curs.ANALIZA),
            new TSA("Sandu", 1800, Functie.PORTAR),
            new CadruDidactic("Andrei", 2200, 12, Curs.MAP),
            new CadruDidactic("Micici", 3000, 8, Curs.CALCUL_NUMERIC),
            new CadruDidactic("iasdasfas", 1390, 7, Curs.CRYPTO),
            new TSA("Ion", 1900, Functie.ECONOMIST),
            new CadruDidactic("Bartlebea", 2100, 10, Curs.MAP),
            new TSA("???", 2200, Functie.CONCUBIN),
            new TSA("Jim Sterling", 3000, Functie.CONCUBIN),
            new CadruDidactic("!!@!*", 12, 13, Curs.ANALIZA),
            new TSA("Mishu", 180000, Functie.ASISTENT),
            new CadruDidactic("Anton", 2000, 10, Curs.CALCUL_NUMERIC),
            new TSA("Sandu", 2110, Functie.PORTAR),
            new TSA("Sandu", 2300, Functie.PORTAR),
    };

    public void showEmployeeData(int type) {
        filterEmployeesByType(type).forEach(
                employee -> {
                    System.out.println("Name: " + employee.name + "; Salary: " + employee.calculateSalary());
                }
        );
    }

    private List<AngajatUTM> filterEmployeesByType(int type) {
        return Arrays.stream(employees)
                .filter(employee -> {
                            if (type == EMPLOYEE_TSA) {
                                return employee instanceof TSA;
                            } else if (type == EMPLOYEE_PROFESSOR) {
                                return employee instanceof CadruDidactic;
                            } else {
                                throw new IllegalArgumentException("INVALID TYPE");
                            }
                        }
                ).collect(Collectors.toList());
    }

}

