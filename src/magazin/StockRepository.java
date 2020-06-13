package magazin;

import java.sql.SQLException;

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
}
