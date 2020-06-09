package clase;

public enum Curs {

    MAP(300),
    CALCUL_NUMERIC(250),
    CRYPTO(280),
    ANALIZA(320);

    private int valuePerCourse;

    public int getValuePerCourse() {
        return valuePerCourse;
    }

    Curs(int valuePerCourse) {
        this.valuePerCourse = valuePerCourse;
    }
}
