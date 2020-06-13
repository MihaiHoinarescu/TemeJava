package magazin;

public class StockEntry {

    private final String firma;
    private final String produs;
    private final int cantitate;
    private final double pretUnitar;
    private final String codMagazin;

    public StockEntry(String firma, String produs, int cantitate, double pretUnitar, String codMagazin) {
        this.firma = firma;
        this.produs = produs;
        this.cantitate = cantitate;
        this.pretUnitar = pretUnitar;
        this.codMagazin = codMagazin;
    }

    public String getFirma() {
        return firma;
    }

    public String getProdus() {
        return produs;
    }

    public int getCantitate() {
        return cantitate;
    }

    public double getPretUnitar() {
        return pretUnitar;
    }

    public String getCodMagazin() {
        return codMagazin;
    }
}
