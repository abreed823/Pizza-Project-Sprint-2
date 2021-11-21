/**
 * The functionality and display for the drink ordering page
 *
 * @author Team 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DrinksPage {
    private JPanel panelDrinks;
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
                    resetPage();
                    Main.updateItemAddedLabel(true);
                    Main.showCardLayout("startOrder");
                }
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
                sizeSelected = true;
                updateItemTotalLabel();
            }
        };
        smallRadioButton.addActionListener(listener);
        mediumRadioButton.addActionListener(listener);
        largeRadioButton.addActionListener(listener);
        ActionListener listener1 = new ActionListener() {
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
        pepsiRadioButton.addActionListener(listener1);
        orangeRadioButton1.addActionListener(listener1);
        rootBeerRadioButton.addActionListener(listener1);
        dietRootBeerRadioButton.addActionListener(listener1);
        dietOrangeRadioButton.addActionListener(listener1);
        dietPepsiRadioButton.addActionListener(listener1);
        sierraMistRadioButton.addActionListener(listener1);
        lemonadeRadioButton.addActionListener(listener1);
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
        return panelDrinks;
    }
}
