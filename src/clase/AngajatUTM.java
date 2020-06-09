package clase;

import java.util.Objects;

public abstract class AngajatUTM {

    protected String name;
    protected int basePay;
    protected final String university = "UTM";

    public AngajatUTM(String name, int basePay) {
        this.name = name;
        this.basePay = basePay;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBasePay() {
        return basePay;
    }

    public void setBasePay(int basePay) {
        this.basePay = basePay;
    }

    public abstract int calculateSalary();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof AngajatUTM)) return false;
        AngajatUTM that = (AngajatUTM) o;
        return basePay == that.basePay &&
                name.equals(that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, basePay, university);
    }
}
