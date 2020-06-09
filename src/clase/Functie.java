package clase;

public enum Functie {
    ECONOMIST(20),
    PORTAR(10),
    ASISTENT(15),
    CONCUBIN(45);

    private int extraPayPercent;

    Functie(int extraPayPercent) {
        this.extraPayPercent = extraPayPercent;
    }

    public int getExtraPayPercent() {
        return extraPayPercent;
    }
}
