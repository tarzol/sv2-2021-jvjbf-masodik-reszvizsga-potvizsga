package filemanipulation;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

public class ProductFileManager {

    List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

    public void readProductsFromFile(Path path) {
        List<String> lines;
        try {
            lines = Files.readAllLines(path);
        } catch (IOException ioe) {
            throw new IllegalStateException("Can't read file!", ioe);
        }
        for (String line : lines) {
            String[] tmp = line.split(";");
            products.add(new Product(tmp[0], tmp[1], Integer.parseInt(tmp[2])));
        }
    }

    public void writePriceOverToFile(Path path, int price) {
        List<String> lines = new ArrayList<>();
        List<Product> expensiveProducts = new ArrayList<>();
        for (Product item : products) {
            if (item.getPrice() > price) {
                expensiveProducts.add(item);
            }
        }

        for ( Product item: expensiveProducts) {
            lines.add(String.join(";", item.getIdentifier(), item.getName(), Integer.toString(item.getPrice())));
        }
        try {
            Files.write(path, lines);
        } catch (IOException ioe) {
            throw new IllegalStateException("File writing is not correct!", ioe);
        }
    }
}
