/**
 * The functionality and display for the drink ordering page
 *
 * @author Team 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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

    private ButtonGroup drinksButtonGroup;
    private ButtonGroup sizesButtonGroup;

    private boolean sizeSelected;
    private boolean drinkSelected;

    /**
     * Constructor
     */
    public DrinksPage() {

        updateCartSubtotalLabel();

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
                }else {
                    Main.updateCartTotal(1);
                    updateCartSubtotalLabel();
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
                updateItemTotalLabel();
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
                updateItemTotalLabel();
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
    }

    /**
     * Updates the Item Total label
     */
    public void updateItemTotalLabel(){
        if(sizeSelected && drinkSelected){
            itemTotalLabel.setText("Item Total: $1.00");
        }
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
        drinksButtonGroup.clearSelection();
        sizesButtonGroup.clearSelection();

        itemTotalLabel.setText("Item Total: $0.00");

        sizeSelected = false;
        drinkSelected = false;

        errorMessageLabel.setText("*Required");
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return drinksPanel;
    }
}
