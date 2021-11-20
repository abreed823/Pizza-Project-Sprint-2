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
    private JButton backButton;
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
        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPage();
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

    public void updateItemTotalLabel(){
        if(sizeSelected && drinkSelected){
            itemTotalLabel.setText("Item Total: $1.00");
        }
    }

    public void resetPage(){
        drinksButtonGroup.clearSelection();
        sizesButtonGroup.clearSelection();

        itemTotalLabel.setText("Item Total: $0.00");

        sizeSelected = false;
        drinkSelected = false;

        errorMessageLabel.setText("*Required");
    }

    public JPanel getPanel(){
        return panelDrinks;
    }
}
