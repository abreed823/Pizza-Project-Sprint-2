/**
 * The functionality and display for the Start Order page
 *
 * @author Team 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartOrderPage {
    private JPanel startOrderPanel;
    private JButton logOutButton;
    private JButton pizzaButton;
    private JButton sidesButton;
    private JButton drinksButton;
    private JButton viewCartButton;
    private JButton backButton;
    private JLabel itemAddedLabel;
    private JLabel cartTotalLabel;

    /**
     * Constructor
     */
    public StartOrderPage() {

        //cartTotalLabel.setText(Main.getCartTotal());

        logOutButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("welcome");
            }
        });
        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("customerWelcome");
            }
        });
        pizzaButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("pizza");
            }
        });
        sidesButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("sides");
            }
        });
        drinksButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("drinks");
            }
        });
        viewCartButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("viewCart");
            }
        });
    }

    /**
     * Updates the Item Added labeled
     * @param add if an item was added to the cart
     */
    public void updateItemAddedLabel(boolean add){
        if(add) {
            itemAddedLabel.setText("Item added successfully!");
        }else{
            itemAddedLabel.setText("");
        }
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return startOrderPanel;
    }
}
