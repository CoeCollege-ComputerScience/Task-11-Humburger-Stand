import java.util.ArrayList;
import java.util.List;

// Main class for testing


public class Main {
    public static void main(String[] args) {
        // create some individual items and a combo of items
        Product hamburger = new Product("Hamburger", 2.50);
        Product fries = new Product("Fries", 1.50);
        Product drink = new Product("Drink", 1.00);
        List<OrderItem> comboItems = new ArrayList<>();
        comboItems.add(hamburger);
        comboItems.add(fries);
        comboItems.add(drink);
        Combo combo = new Combo("Combo #1", comboItems);

        // create an order and add items to it
        Order order = new Order();
        order.addItem(hamburger);
        order.addItem(fries);
        order.addItem(drink);
        order.addItem(combo);

        // add more items to the order
        Product chickenSandwich = new Product("Chicken Sandwich", 3.00);
        order.addItem(chickenSandwich);

        List<OrderItem> comboItems2 = new ArrayList<>();
        comboItems2.add(hamburger);
        comboItems2.add(drink);
        Combo combo2 = new Combo("Combo #2", comboItems2);
        order.addItem(combo2);

        // display the order and get the total price
        order.display();
        System.out.println("Total price: $" + order.getTotalPrice());

        // remove an item from the order and display the updated order and total price
        order.removeItem(fries);
        System.out.println("Updated order:");
        order.display();
        System.out.println("Updated total price: $" + order.getTotalPrice());
    }
}
