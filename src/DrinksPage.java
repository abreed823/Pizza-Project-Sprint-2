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

    public DrinksPage() {
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
                Main.showCardLayout("startOrder");
            }
        });
    }

    public JPanel getPanel(){
        return panelDrinks;
    }
}
