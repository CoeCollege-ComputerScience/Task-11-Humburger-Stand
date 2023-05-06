import java.util.ArrayList;
import java.util.List;

// Product class for individual items
class Product implements OrderItem {
    private String itemName;
    private double price;

    public Product(String itemName, double price) {
        this.itemName = itemName;
        this.price = price;
    }

    @Override
    public String getName() {
        return itemName;
    }

    @Override
    public double getPrice() {
        return price;
    }
}
