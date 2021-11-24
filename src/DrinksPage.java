import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

/**
 * The functionality and display for the drink ordering page
 *
 * @author Team 2
 */
public class DrinksPage {
    private JPanel drinksPanel;
    private JButton logOutButton;
    private JRadioButton pepsiRadioButton;
    private JRadioButton orangeRadioButton1;
    private JRadioButton rootBeerRadioButton;
    private JRadioButton dietRootBeerRadioButton;
    private JRadioButton dietOrangeRadioButton;
    private JRadioButton dietPepsiRadioButton;
    private JRadioButton sierraMistRadioButton;
    private JRadioButton lemonadeRadioButton;
    private JButton cancelButton;
    private JButton addToCartButton;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JLabel itemTotalLabel;
    private JLabel cartSubtotalLabel;
    private JLabel errorMessageLabel;
    private JComboBox<String> quantityComboBox;

    private ButtonGroup drinksButtonGroup;
    private ButtonGroup sizesButtonGroup;

    private boolean sizeSelected;
    private boolean drinkSelected;

    /**
     * Constructor
     */
    public DrinksPage() {

        drinksButtonGroup = new ButtonGroup();
        drinksButtonGroup.add(pepsiRadioButton);
        drinksButtonGroup.add(dietPepsiRadioButton);
        drinksButtonGroup.add(orangeRadioButton1);
        drinksButtonGroup.add(dietOrangeRadioButton);
        drinksButtonGroup.add(rootBeerRadioButton);
        drinksButtonGroup.add(dietRootBeerRadioButton);
        drinksButtonGroup.add(sierraMistRadioButton);
        drinksButtonGroup.add(lemonadeRadioButton);

        sizesButtonGroup = new ButtonGroup();
        sizesButtonGroup.add(smallRadioButton);
        sizesButtonGroup.add(mediumRadioButton);
        sizesButtonGroup.add(largeRadioButton);

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
                if(!(sizeSelected && drinkSelected)){
                    errorMessageLabel.setText("*Please make all required selections.");
                }else if(quantityComboBox.getSelectedIndex() == 0){
                    errorMessageLabel.setText("*Please select a quantity");
                }else {
                    Main.updateCartTotal(Double.parseDouble(getQuantity()));
                    resetPage();
                    Main.updateItemAddedLabel(true);
                    Main.showCardLayout("startOrder");
                }
            }
        });
        ActionListener sizeButtonListener = new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                sizeSelected = true;
                updateItemTotalLabel(Integer.parseInt(getQuantity()));
            }
        };
        smallRadioButton.addActionListener(sizeButtonListener);
        mediumRadioButton.addActionListener(sizeButtonListener);
        largeRadioButton.addActionListener(sizeButtonListener);
        ActionListener drinkButtonListener = new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                drinkSelected = true;
                updateItemTotalLabel(Integer.parseInt(getQuantity()));
            }
        };
        pepsiRadioButton.addActionListener(drinkButtonListener);
        orangeRadioButton1.addActionListener(drinkButtonListener);
        rootBeerRadioButton.addActionListener(drinkButtonListener);
        dietRootBeerRadioButton.addActionListener(drinkButtonListener);
        dietOrangeRadioButton.addActionListener(drinkButtonListener);
        dietPepsiRadioButton.addActionListener(drinkButtonListener);
        sierraMistRadioButton.addActionListener(drinkButtonListener);
        lemonadeRadioButton.addActionListener(drinkButtonListener);
        drinksPanel.addComponentListener(new ComponentAdapter() {
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
        quantityComboBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateItemTotalLabel(Integer.parseInt(getQuantity()));
            }
        });
    }

    /**
     * Updates the Item Total label
     */
    public void updateItemTotalLabel(int quantity){
        if(sizeSelected && drinkSelected){
            itemTotalLabel.setText("Item Total: $" + quantity + ".00");
        }
    }

    /**
     * Updates the cart subtotal label
     */
    public void updateCartSubtotalLabel(){
        cartSubtotalLabel.setText(Main.getCartTotalString());
    }

    /**
     * Resets the page to its original state
     */
    public void resetPage(){
        drinksButtonGroup.clearSelection();
        sizesButtonGroup.clearSelection();
        quantityComboBox.setSelectedIndex(0);
        itemTotalLabel.setText("Item Total: $0.00");
        sizeSelected = false;
        drinkSelected = false;
        errorMessageLabel.setText("*Required");
    }

    /**
     * Returns the drink quantity that the user selects
     * @return A string for the quantity of the drink
     */
    public String getQuantity(){
        if(quantityComboBox.getSelectedIndex() == 0 || quantityComboBox.getSelectedIndex() == 1){
            return "1";
        }
        return String.valueOf(quantityComboBox.getSelectedItem());
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return drinksPanel;
    }
}
