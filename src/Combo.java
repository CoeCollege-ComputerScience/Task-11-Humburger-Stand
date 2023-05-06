import java.util.ArrayList;
import java.util.List;

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

