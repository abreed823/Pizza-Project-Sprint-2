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

    private ButtonGroup drinksButtonGroup;
    private ButtonGroup sizesButtonGroup;

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
                resetRadioButtons();
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
                resetRadioButtons();
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
                resetRadioButtons();
                Main.showCardLayout("startOrder");
            }
        });
    }

    public void resetRadioButtons(){
        drinksButtonGroup.clearSelection();
        sizesButtonGroup.clearSelection();
    }

    public JPanel getPanel(){
        return panelDrinks;
    }
}
