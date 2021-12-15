package filemanipulation;

public class Product {

    private String identifier;
    private String name;
    private int price;

    public Product(String identifier, String name, int price) {
        this.identifier = identifier;
        this.name = name;
        this.price = price;
    }

    public String getIdentifier() {
        return identifier;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}
