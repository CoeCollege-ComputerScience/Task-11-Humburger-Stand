import java.util.ArrayList;
import java.util.List;

// Order class for managing a customer's order
import java.util.ArrayList;
import java.util.List;

public class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(OrderItem item) {
        items.remove(item);
    }

    public double getTotalPrice() {
        double totalPrice = 0.0;
        for (OrderItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }

    public void display() {
        System.out.println("Order:");
        for (OrderItem item : items) {
            System.out.println("- " + item.getName() + ": $" + item.getPrice());
        }
    }
}

