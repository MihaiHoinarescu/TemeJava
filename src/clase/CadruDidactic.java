package clase;

import java.util.Objects;

public class CadruDidactic extends AngajatUTM{

    private int monthlyHours;
    private Curs course;

    public CadruDidactic(String name, int basePay, int monthlyHours, Curs course) {
        super(name, basePay);
        this.monthlyHours = monthlyHours;
        this.course = course;
    }

    @Override
    public int calculateSalary() {
        return basePay + monthlyHours * course.getValuePerCourse();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CadruDidactic)) return false;
        if (!super.equals(o)) return false;
        CadruDidactic that = (CadruDidactic) o;
        return monthlyHours == that.monthlyHours &&
                course == that.course;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), monthlyHours, course);
    }

    @Override
    public String toString() {
        return "CadruDidactic{" +
                "monthlyHours=" + monthlyHours +
                ", course=" + course +
                ", name='" + name + '\'' +
                ", basePay=" + basePay +
                ", university='" + university + '\'' +
                '}';
    }
}
