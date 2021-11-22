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
    private JComboBox breadSticksComboBox;
    private JComboBox breadBitesComboBox;
    private JComboBox cookieComboBox;

    private ArrayList<JCheckBox> checkBoxes;

    private double sidesPrice;
    private double breadSticksPrice;
    private double breadBitesPrice;
    private double cookiePrice;
    private String totalPrice;

    /**
     * Constructor
     */
    public SidesPage() {

        breadSticksPrice = 0;
        breadBitesPrice = 0;
        cookiePrice = 0;

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
                updateSticksPrice();
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
                updateBitesPrice();
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
                updateCookiePrice();
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
        breadSticksComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(breadSticksCheckBox.isSelected()){
                    updateSidesTotalPrice();
                }
            }
        });
        breadBitesComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(breadBitesCheckBox.isSelected()) {
                    updateSidesTotalPrice();
                }
            }
        });
        cookieComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(cookieCheckBox.isSelected()){
                    updateSidesTotalPrice();
                }
            }
        });
    }

    /**
     * Updates the total price of the decides depending on if a checkbox is selected
     *
     */
    //JCheckBox box, double itemPrice
    public void updateSidesTotalPrice(){
        sidesPrice = breadSticksPrice + breadBitesPrice + cookiePrice;
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
     * Returns the drink quantity that the user selects
     * @return A string for the quantity of the drink
     */
    public String getSticksQuantity(){
        if(breadSticksComboBox.getSelectedIndex() == 0 || breadSticksComboBox.getSelectedIndex() == 1){
            return "1";
        }
        return String.valueOf(breadSticksComboBox.getSelectedItem());
    }

    /**
     * Returns the drink quantity that the user selects
     * @return A string for the quantity of the drink
     */
    public String getBitesQuantity(){
        if(breadBitesComboBox.getSelectedIndex() == 0 || breadBitesComboBox.getSelectedIndex() == 1){
            return "1";
        }
        return String.valueOf(breadBitesComboBox.getSelectedItem());
    }

    /**
     * Returns the drink quantity that the user selects
     * @return A string for the quantity of the drink
     */
    public String getCookieQuantity(){
        if(cookieComboBox.getSelectedIndex() == 0 || cookieComboBox.getSelectedIndex() == 1){
            return "1";
        }
        return String.valueOf(cookieComboBox.getSelectedItem());
    }

    public void updateSticksPrice(){
        //if(breadSticksCheckBox.isSelected()){}
        breadSticksPrice = Double.parseDouble(getSticksQuantity()) * 4;
    }

    public void updateBitesPrice(){
        breadBitesPrice = Double.parseDouble(getBitesQuantity()) * 2;
    }

    public void updateCookiePrice(){
        cookiePrice = Double.parseDouble(getCookieQuantity()) * 4;
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
        breadSticksComboBox.setSelectedIndex(0);
        breadBitesComboBox.setSelectedIndex(0);
        cookieComboBox.setSelectedIndex(0);
        breadSticksPrice = 0;
        breadBitesPrice = 0;
        cookiePrice = 0;
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return sidesPanel;
    }
}
