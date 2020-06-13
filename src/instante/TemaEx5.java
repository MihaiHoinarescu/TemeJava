package instante;

import magazin.ProductDB;
import magazin.StockRepository;

import java.util.Scanner;

public class TemaEx5 {

    public static void main(String[] args) {

        ProductDB db = new ProductDB("jdbc:sqlite:produse.sqlite3");
        StockRepository repository = new StockRepository(db);

        Scanner kb = new Scanner(System.in);
        String input ="";
        System.out.println("Insert the shop name and the brand split by a comma");

        while (!input.equals("exit")) {
            input = kb.nextLine();
            String[] arguments = input.split(",");
            if (arguments.length != 2) {
                System.out.println("Invalid input!");
                continue;
            }
            System.out.println(repository.getStock(arguments[0], arguments[1]));
        }

        System.exit(0);
    }
}
