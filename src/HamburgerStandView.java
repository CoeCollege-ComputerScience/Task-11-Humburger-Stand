import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HamburgerStandView extends JFrame implements ActionListener {
    private JButton hamburgerButton;
    private JButton chickenSandwichButton;
    private JButton friesButton;
    private JButton popButton;
    private JButton combo1Button;
    private JButton combo2Button;
    private OrderModel orderModel;

    public HamburgerStandView(OrderModel orderModel) {
        this.orderModel = orderModel;
        initializeComponents();
    }

    public void initializeComponents() {
        setTitle("Hamburger Stand");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create buttons for ordering individual items
        hamburgerButton = new JButton("Hamburger - $3.99");
        hamburgerButton.addActionListener(this);
        add(hamburgerButton);

        chickenSandwichButton = new JButton("Chicken Sandwich - $4.49");
        chickenSandwichButton.addActionListener(this);
        add(chickenSandwichButton);

        friesButton = new JButton("Fries - $1.99");
        friesButton.addActionListener(this);
        add(friesButton);

        popButton = new JButton("Pop - $1.49");
        popButton.addActionListener(this);
        add(popButton);

        // Create buttons for ordering combo meals
        combo1Button = new JButton("Combo #1: Hamburger, Pop, Fries - $6.97 (10% off)");
        combo1Button.addActionListener(this);
        add(combo1Button);

        combo2Button = new JButton("Combo #2: Chicken Sandwich, Pop, Fries - $7.41 (10% off)");
        combo2Button.addActionListener(this);
        add(combo2Button);

        pack();
        setVisible(true);
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
            Combo combo1 = new Combo("Combo #1");
            combo1.addItem(new Product("Hamburger", 3.99));
            combo1.addItem(new Product("Pop", 1.49));
            combo1.addItem(new Product("Fries", 1.99));
            orderModel.addItem(combo1);
        } else if (e.getSource() == combo2Button) {
            Combo combo2 = new Combo("Combo #2");
            combo2.addItem(new Product("Chicken Sandwich", 4.49));
            combo2.addItem(new Product("Pop", 1.49));
            combo2.addItem(new Product("Fries", 1.99));
            orderModel.addItem(combo2);
        }

        updateDisplay();
    }

    public void updateDisplay() {
        System.out.println(orderModel.toString());
    }
}


