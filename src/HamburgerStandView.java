import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import path.to.OrderView;

public class HamburgerStandView extends OrderView implements ActionListener {
    private JButton hamburgerButton;
    private JButton chickenSandwichButton;
    private JButton friesButton;
    private JButton popButton;
    private JButton combo1Button;
    private JButton combo2Button;

    public HamburgerStandView(OrderModel orderModel) {
        super(orderModel);
    }

    @Override
    public void initializeComponents() {
        super.initializeComponents();
        setTitle("Hamburger Stand");

        // Create buttons for ordering individual items
        hamburgerButton = new JButton("Hamburger - $3.99");
        hamburgerButton.addActionListener(this);
        addComponent(hamburgerButton);

        chickenSandwichButton = new JButton("Chicken Sandwich - $4.49");
        chickenSandwichButton.addActionListener(this);
        addComponent(chickenSandwichButton);

        friesButton = new JButton("Fries - $1.99");
        friesButton.addActionListener(this);
        addComponent(friesButton);

        popButton = new JButton("Pop - $1.49");
        popButton.addActionListener(this);
        addComponent(popButton);

        // Create buttons for ordering combo meals
        combo1Button = new JButton("Combo #1: Hamburger, Fries, Pop - $6.97 (10% off)");
        combo1Button.addActionListener(this);
        addComponent(combo1Button);

        combo2Button = new JButton("Combo #2: Chicken Sandwich, Fries, Pop - $7.41 (10% off)");
        combo2Button.addActionListener(this);
        addComponent(combo2Button);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == hamburgerButton) {
            orderModel.addItem(new Product("Hamburger", 3.99));
        } else if (e.getSource() == chickenSandwichButton) {
            orderModel.addItem(new Product("Chicken Sandwich", 4.49));
        } else if (e.getSource() == friesButton) {
            orderModel.addItem(new Product("Fries", 1.99));
        } else if (e.getSource() == popButton) {
            orderModel.addItem(new Product("Pop", 1.49));
        } else if (e.getSource() == combo1Button) {
            Combo combo1 = new Combo("Combo #1",
                    new Product("Hamburger", 3.99),
                    new Product("Fries", 1.99),
                    new Product("Pop", 1.49));
            orderModel.addItem(combo1);
        } else if (e.getSource() == combo2Button) {
            Combo combo2 = new Combo("Combo #2",
                    new Product("Chicken Sandwich", 4.49),
                    new Product("Fries", 1.99),
                    new Product("Pop", 1.49));
            orderModel.addItem(combo2);
        }

        updateDisplay();
    }
}



