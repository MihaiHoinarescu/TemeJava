package magazin;

import java.sql.*;
import java.util.List;

public class ProductDB {

    private final String URL;

    public ProductDB(String URL) {
        this.URL = URL;
    }

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(URL);
    }

    // Mi-e lene sa inserez de mana ok?
    public synchronized void insertStock(List<StockEntry> entries) throws SQLException {
        Connection connection = connect();
        PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO stoc VALUES (?, ?, ?, ?, ?)");

        for (StockEntry entry : entries) {
            preparedStatement.setString(1, entry.getFirma());
            preparedStatement.setString(2, entry.getProdus());
            preparedStatement.setInt(3, entry.getCantitate());
            preparedStatement.setDouble(4, entry.getPretUnitar());
            preparedStatement.setString(5, entry.getCodMagazin());
            preparedStatement.addBatch();
        }

        preparedStatement.executeBatch();
        preparedStatement.close();
        connection.close();
    }


    public int getQuantity(String shop, String brand) throws SQLException {
        Connection connection = connect();
        PreparedStatement statement = connection.prepareStatement("SELECT cantitate FROM stoc WHERE firma=? AND cod_magazin=?");
        statement.setString(1, brand);
        statement.setString(2, shop);
        ResultSet result = statement.executeQuery();

        int quantity = 0;
        while (result.next()) {
            quantity += result.getInt("cantitate");
        }
        statement.close();
        connection.close();

        return quantity;
    }

}
