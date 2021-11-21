/**
 * The functionality and display for the Sides Selection page
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class SidesPage {
    private JButton logOutButton;
    private JPanel sidesPanel;
    private JCheckBox breadSticksCheckBox;
    private JCheckBox breadBitesCheckBox;
    private JCheckBox cookieCheckBox;
    private JButton cancelButton;
    private JButton addToCartButton;
    private JLabel itemTotalLabel;
    private JLabel cartSubtotalLabel;
    private JLabel errorMessageLabel;

    private ArrayList<JCheckBox> checkBoxes;

    private double sidesPrice;
    private String totalPrice;

    /**
     * Constructor
     */
    public SidesPage() {

        checkBoxes = new ArrayList<JCheckBox>();
        checkBoxes.add(breadBitesCheckBox);
        checkBoxes.add(breadSticksCheckBox);
        checkBoxes.add(cookieCheckBox);

        cancelButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPage();
                Main.updateItemAddedLabel(false);
                Main.showCardLayout("startOrder");
            }
        });
        addToCartButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(!sidesAreSelected()){
                    errorMessageLabel.setText("*Please make all required selections.");
                }else {
                    Main.updateCartTotal(sidesPrice);
                    resetPage();
                    Main.updateItemAddedLabel(true);
                    Main.showCardLayout("startOrder");
                }
            }
        });
        logOutButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPage();
                Main.showCardLayout("welcome");
            }
        });
        breadSticksCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSidesPrice(breadSticksCheckBox, 4);
            }
        });
        breadBitesCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSidesPrice(breadBitesCheckBox, 2);
            }
        });
        cookieCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSidesPrice(cookieCheckBox, 4);
            }
        });
        sidesPanel.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component has been made visible.
             *
             * @param e
             */
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                updateCartSubtotalLabel();
            }
        });
    }

    /**
     * Updates the total price of the decides depending on if a checkbox is selected
     * @param box the checkbox that was toggled
     * @param itemPrice the price of the side item that was toggled
     */
    public void updateSidesPrice(JCheckBox box, double itemPrice){
        if(box.isSelected()){
            sidesPrice += itemPrice;
        }else{
            sidesPrice -= itemPrice;
        }
        totalPrice = String.format("%.2f",sidesPrice);
        itemTotalLabel.setText("Item Total: $" + totalPrice);
    }

    /**
     * Determines if there are any side item checkboxes selected
     * @return if there are any side item checkboxes selected
     */
    public boolean sidesAreSelected(){
        for(JCheckBox box: checkBoxes){
            if(box.isSelected()){
                return true;
            }
        }
        return false;
    }

    /**
     * Updates the cart subtotal label
     */
    public void updateCartSubtotalLabel(){
        cartSubtotalLabel.setText(Main.getCartTotal());
    }

    /**
     * Resets the page to its original state
     */
    public void resetPage(){
        for(JCheckBox checkBox: checkBoxes){
            checkBox.setSelected(false);
        }

        sidesPrice = 0;
        itemTotalLabel.setText("Item Total: $0.00");

        errorMessageLabel.setText("*Required");
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return sidesPanel;
    }
}
