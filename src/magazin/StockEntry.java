package magazin;

public class StockEntry {

    private final String firma;
    private final String produs;
    private final int cantitate;
    private final int pret_unitar;
    private final String cod_magazin;

    public StockEntry(String firma, String produs, int cantitate, int pret_unitar, String cod_magazin) {
        this.firma = firma;
        this.produs = produs;
        this.cantitate = cantitate;
        this.pret_unitar = pret_unitar;
        this.cod_magazin = cod_magazin;
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

    public int getPretUnitar() {
        return pret_unitar;
    }

    public String getCodMagazin() {
        return cod_magazin;
    }
}
