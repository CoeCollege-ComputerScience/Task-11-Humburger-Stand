import java.util.ArrayList;
import java.util.List;

// Main class for testing

public class Main {
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