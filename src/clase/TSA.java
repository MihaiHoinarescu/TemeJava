package clase;

import com.sun.istack.internal.NotNull;

import java.util.Objects;

public class TSA extends AngajatUTM {

    private @NotNull Functie functie;

    public TSA(String name, int basePay, Functie functie) {
        super(name, basePay);
        this.functie = functie;
    }

    @Override
    public int calculateSalary() {
        return basePay + (basePay * functie.getExtraPayPercent()) / 100;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof TSA)) return false;
        if (!super.equals(o)) return false;
        TSA tsa = (TSA) o;
        return functie == tsa.functie;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), functie);
    }

    @Override
    public String toString() {
        return "TSA{" +
                "functie=" + functie +
                ", name='" + name + '\'' +
                ", basePay=" + basePay +
                ", university='" + university + '\'' +
                '}';
    }
}
