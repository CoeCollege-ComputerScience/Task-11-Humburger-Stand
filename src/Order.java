import java.util.ArrayList;
import java.util.List;

// Order class for managing a customer's order
class Order {
    private List<OrderItem> items;

    public Order() {
        items = new ArrayList<>();
    }

    public void addItem(OrderItem item) {
        items.add(item);
    }

    public void removeItem(int index) {
        items.remove(index);
    }

    public void displayOrder() {
        System.out.println("Order items:");
        for (int i = 0; i < items.size(); i++) {
            System.out.printf("%d. %s - $%.2f\n", i+1, items.get(i).getName(), items.get(i).getPrice());
        }
    }

    public double getTotalPrice() {
        double totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getPrice();
        }
        return totalPrice;
    }
}
