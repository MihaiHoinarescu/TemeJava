package magazin;

import java.sql.SQLException;
import java.util.List;

/**
 * There should be a lot more abstraction here but I'm out of whiskey so this is what you get.
 */
public class StockRepository {

    private final ProductDB db;

    public StockRepository(ProductDB db) {
        this.db = db;
    }

    public int getStock(String shopName, String brand) {
        int stock = -1;
        try {
            stock = db.getQuantity(shopName, brand);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return stock;
    }

    public void insertStockEntries(List<StockEntry> entries) {
        try {
            db.insertStock(entries);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}
