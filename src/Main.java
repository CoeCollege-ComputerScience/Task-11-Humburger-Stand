import java.util.ArrayList;
import java.util.List;

// OrderItem interface for individual items or combos
interface OrderItem {
    public String getName();
    public double getPrice();
}

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

// Combo class for collections of items
class Combo implements OrderItem {
    private String comboName;
    private List<OrderItem> items;

    public Combo(String comboName, List<OrderItem> items) {
        this.comboName = comboName;
        this.items = items;
    }

    @Override
    public String getName() {
        // derive combo name from individual items
        StringBuilder nameBuilder = new StringBuilder(comboName);
        for (OrderItem item : items) {
            nameBuilder.append(" + ").append(item.getName());
        }
        return nameBuilder.toString();
    }

    @Override
    public double getPrice() {
        // sum up prices of individual items
        double totalPrice = 0;
        for (OrderItem item : items) {
            totalPrice += item.getPrice();
        }
        // apply combo discount
        if (items.size() >= 3) {
            totalPrice -= 1.0; // assuming $1 discount for combos
        }
        return totalPrice;
    }
}

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

// Main class for testing
class HamburgerStand {
    public static void main(String[] args) {
        // create some individual items
        OrderItem burger = new Product("Hamburger", 3.99);
        OrderItem fries = new Product("French Fries", 1.99);
        OrderItem pop = new Product("Soda Pop", 0.99);
        // create a combo of individual items
        List<OrderItem> comboItems = new ArrayList<>();
        comboItems.add(burger);
        comboItems.add(fries);
        comboItems.add(pop);
        OrderItem combo1 = new Combo("Combo #1", comboItems);
        // create an order and add items
        Order order = new Order();
        order.addItem(burger);
        order.addItem(combo1);
        order.addItem(pop);
        order.displayOrder();
        System.out.printf("Total price: $%.2f\n", order.getTotalPrice());
        // remove an item and display updated order
        order.removeItem(1);
        order.displayOrder();
        System.out.printf("Total price: $%.2f\n", order.getTotalPrice());
    }
}


