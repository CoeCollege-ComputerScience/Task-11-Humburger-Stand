import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class HamburgerStandController {
    private HamburgerStandView hamburgerStandView;
    private OrderModel orderModel;

    public HamburgerStandController(HamburgerStandView view, OrderModel model) {
        hamburgerStandView = view;
        orderModel = model;

        // set button listeners
        hamburgerStandView.setButtonListeners(new ButtonListener());
    }

    public class ButtonListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == hamburgerStandView.getHamburgerButton()) {
                orderModel.addItem(new Product("Hamburger", 3.99));
            } else if (e.getSource() == hamburgerStandView.getChickenSandwichButton()) {
                orderModel.addItem(new Product("Chicken Sandwich", 4.49));
            } else if (e.getSource() == hamburgerStandView.getFriesButton()) {
                orderModel.addItem(new Product("Fries", 1.99));
            } else if (e.getSource() == hamburgerStandView.getPopButton()) {
                orderModel.addItem(new Product("Pop", 1.49));
            } else if (e.getSource() == hamburgerStandView.getCombo1Button()) {
                Combo combo1 = new Combo("Combo #1");
                combo1.addItem(new Product("Hamburger", 3.99));
                combo1.addItem(new Product("Pop", 1.49));
                combo1.addItem(new Product("Fries", 1.99));
                orderModel.addItem(combo1);
            } else if (e.getSource() == hamburgerStandView.getCombo2Button()) {
                Combo combo2 = new Combo("Combo #2");
                combo2.addItem(new Product("Chicken Sandwich", 4.49));
                combo2.addItem(new Product("Pop", 1.49));
                combo2.addItem(new Product("Fries", 1.99));
                orderModel.addItem(combo2);
            }

            // update view
            hamburgerStandView.setItems(orderModel.toString());
            hamburgerStandView.setTotal(orderModel.getTotal());
        }
    }
}

