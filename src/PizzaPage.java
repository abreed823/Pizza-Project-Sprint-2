/**
 * The functionality and display for the Pizza Ordering page
 *
 * @author Team 2
 */
//TODO fix issue - update subtotal labels whenever a page is opened, not just when you add to cart
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.util.ArrayList;

public class PizzaPage {
    private JButton logOutButton;
    private JPanel pizzaPanel;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JRadioButton xLargeRadioButton;
    private JCheckBox pepperoniCheckBox;
    private JCheckBox onionCheckBox;
    private JCheckBox mushroomCheckBox;
    private JCheckBox hamCheckBox;
    private JCheckBox sausageCheckBox;
    private JCheckBox pineappleCheckBox;
    private JCheckBox greenPepperCheckBox;
    private JCheckBox tomatoCheckBox;
    private JCheckBox extraCheeseCheckBox;
    private JRadioButton originalRadioButton;
    private JRadioButton panRadioButton;
    private JRadioButton thinRadioButton;
    private JButton cancelButton;
    private JButton addToCartButton;
    private JLabel itemTotalLabel;
    private JLabel cartSubtotalLabel;
    private JLabel errorMessageLabel;
    private JComboBox quantityComboBox;

    private ButtonGroup sizesButtonGroup;
    private ButtonGroup crustButtonGroup;

    private double toppingsCounter;

    private ArrayList<JCheckBox> boxesToDisable;
    private boolean disabled;

    private double sizePrice;
    private double toppingsPrice;
    private double pricePerTopping;
    private String itemTotalPrice;

    private boolean sizeSelected;
    private boolean crustSelected;

    /**
     * Constructor
     */
    public PizzaPage() {

        sizeSelected = false;
        crustSelected = false;

        boxesToDisable = new ArrayList<JCheckBox>();
        addCheckBoxes();
        disabled = false;
        toppingsCounter = 0;
        pricePerTopping = 0;

        sizesButtonGroup = new ButtonGroup();
        sizesButtonGroup.add(smallRadioButton);
        sizesButtonGroup.add(mediumRadioButton);
        sizesButtonGroup.add(largeRadioButton);
        sizesButtonGroup.add(xLargeRadioButton);

       crustButtonGroup = new ButtonGroup();
       crustButtonGroup.add(originalRadioButton);
       crustButtonGroup.add(thinRadioButton);
       crustButtonGroup.add(panRadioButton);

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
                if(!(sizeSelected && crustSelected)){
                    errorMessageLabel.setText("*Please make all required selections.");
                }else if(quantityComboBox.getSelectedIndex() == 0){
                    errorMessageLabel.setText("*Please select a quantity");
                }else {
                    Main.updateCartTotal((Double.parseDouble(getQuantity()))*(sizePrice + toppingsPrice));
                    resetPage();
                    Main.updateItemAddedLabel(true);
                    Main.showCardLayout("startOrder");
                }
            }
        });

        pepperoniCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(pepperoniCheckBox);
            }
        });
        hamCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(hamCheckBox);
            }
        });
        greenPepperCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(greenPepperCheckBox);
            }
        });
        onionCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(onionCheckBox);
            }
        });
        sausageCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(sausageCheckBox);
            }
        });
        tomatoCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(tomatoCheckBox);
            }
        });
        mushroomCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(mushroomCheckBox);
            }
        });
        pineappleCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(pineappleCheckBox);
            }
        });
        extraCheeseCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(extraCheeseCheckBox);
            }
        });
        smallRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                pricePerTopping = 0.5;
                updateSizePrice(4.00);
            }
        });
        mediumRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                pricePerTopping = 0.75;
                updateSizePrice(6.00);
            }
        });
        largeRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                pricePerTopping = 1;
                updateSizePrice(8.00);
            }
        });
        xLargeRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                pricePerTopping = 1.25;
                updateSizePrice(10.00);
            }
        });
        ActionListener listener = new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                crustSelected = true;
            }
        };
        originalRadioButton.addActionListener(listener);
        panRadioButton.addActionListener(listener);
        thinRadioButton.addActionListener(listener);
        pizzaPanel.addComponentListener(new ComponentAdapter() {
            /**
             * Invoked when the component has been made visible
             *
             * @param e
             */
            @Override
            public void componentShown(ComponentEvent e) {
                super.componentShown(e);
                updateCartSubtotalLabel();
            }
        });
        quantityComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItemTotal(sizePrice, toppingsPrice);
            }
        });
    }

    /**
     * Adds all of the checkboxes to an ArrayList
     */
    public void addCheckBoxes(){
        boxesToDisable.clear();
        boxesToDisable.add(pepperoniCheckBox);
        boxesToDisable.add(onionCheckBox);
        boxesToDisable.add(mushroomCheckBox);
        boxesToDisable.add(hamCheckBox);
        boxesToDisable.add(sausageCheckBox);
        boxesToDisable.add(pineappleCheckBox);
        boxesToDisable.add(greenPepperCheckBox);
        boxesToDisable.add(tomatoCheckBox);
        boxesToDisable.add(extraCheeseCheckBox);
    }

    /**
     * Updates the boxesToDisable ArrayList whenever a checkbox is toggled
     * @param box the box that is toggled
     */
    public void toggleCheckBox(JCheckBox box){
        if(box.isSelected()){
            boxesToDisable.remove(box);
            changeToppingsCounter(true);
        }else{
            boxesToDisable.add(box);
            changeToppingsCounter(false);
        }
    }

    /**
     * Updates the topping counter and price whenever a checkbox is toggled
     * @param boxIsChecked indicates whether a box has been checked or not
     */
    public void changeToppingsCounter(boolean boxIsChecked){
        if(boxIsChecked){
            toppingsCounter++;
        }else{
            toppingsCounter--;
        }
        updateToppingsPrice(pricePerTopping, toppingsCounter);
        if(toppingsCounter == 4){
            disableCheckBoxes();
        }else if(disabled){
            enableCheckBoxes();
        }
    }

    /**
     * Disables all checkboxes left is the ArrayList
     */
    public void disableCheckBoxes(){
        for(JCheckBox box: boxesToDisable){
            box.setEnabled(false);
        }
        disabled = true;
    }

    /**
     * Enables all checkboxes
     */
    public void enableCheckBoxes(){
        for(JCheckBox box: boxesToDisable){
            box.setEnabled(true);
        }
        disabled = false;
    }

    /**
     * Updates the price of the pizza based on the size
     * @param sizePrice the prize of the selected pizza size
     */
    public void updateSizePrice(double sizePrice){
        sizeSelected = true;
        this.sizePrice = sizePrice;
        updateToppingsPrice(pricePerTopping, toppingsCounter);
    }

    /**
     * Updates the price of the toppings depending on the pizza size
     * @param pricePerTopping the price per topping
     * @param toppingsCounter how many topping are selected
     */
    public void updateToppingsPrice(double pricePerTopping, double toppingsCounter){
        toppingsPrice = pricePerTopping * toppingsCounter;
        updateItemTotal(sizePrice, toppingsPrice);
    }

    /**
     * Updates the total price of the pizza
     * @param sizePrice the prize of the pizza size
     * @param toppingsPrice the price of the toppings
     */
    public void updateItemTotal(double sizePrice, double toppingsPrice){
        itemTotalPrice = String.format("%.2f",(Double.parseDouble(getQuantity()))*(sizePrice + toppingsPrice));
        itemTotalLabel.setText("Item Total: $" + itemTotalPrice);
    }

    /**
     * Updates the cart subtotal label
     */
    public void updateCartSubtotalLabel(){
        cartSubtotalLabel.setText(Main.getCartTotalString());
    }

    /**
     * Returns the pizza quantity that the user selects
     * @return A string for the quantity of the pizza
     */
    public String getQuantity(){
        if(quantityComboBox.getSelectedIndex() == 0 || quantityComboBox.getSelectedIndex() == 1){
            return "1";
        }
        return String.valueOf(quantityComboBox.getSelectedItem());
    }

    /**
     * Resets the page to its original state
     */
    public void resetPage(){
        addCheckBoxes();
        enableCheckBoxes();
        toppingsCounter = 0;
        for(JCheckBox box: boxesToDisable){
            box.setSelected(false);
        }

        sizesButtonGroup.clearSelection();
        crustButtonGroup.clearSelection();
        pricePerTopping = 0;
        sizePrice = 0;
        quantityComboBox.setSelectedIndex(0);
        itemTotalLabel.setText("Item Total: $0.00");
        errorMessageLabel.setText("*Required");
        sizeSelected = false;
        crustSelected = false;
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return pizzaPanel;
    }
}
