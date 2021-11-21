/**
 * The display and functionality for the checkout page
 *
 * @author Team 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CheckOutPage {
    private JPanel checkOutPanel;
    private JButton logOutButton;
    private JRadioButton cardRadioButton;
    private JRadioButton cashRadioButton;
    private JRadioButton checkRadioButton;
    private JButton backButton;
    private JButton continueButton;

    private ButtonGroup paymentMethodButtonGroup;

    private boolean payWithCard;
    private boolean paymentMethodSelected;

    /**
     * Constructor
     */
    public CheckOutPage() {
        paymentMethodButtonGroup = new ButtonGroup();
        paymentMethodButtonGroup.add(cardRadioButton);
        paymentMethodButtonGroup.add(cashRadioButton);
        paymentMethodButtonGroup.add(checkRadioButton);

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
                resetPage();
                Main.showCardLayout("viewCart");
            }
        });
        continueButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(payWithCard && paymentMethodSelected){
                    resetPage();
                    Main.showCardLayout("payCard");
                }else if(!payWithCard && paymentMethodSelected){
                    resetPage();
                    Main.showCardLayout("payCash");
                }
            }
        });
        cardRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                payWithCard = true;
                paymentMethodSelected = true;
            }
        });
        ActionListener cashCheckListener = new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                payWithCard = false;
                paymentMethodSelected = true;
            }
        };
        cashRadioButton.addActionListener(cashCheckListener);
        checkRadioButton.addActionListener(cashCheckListener);
    }

    /**
     * Resets the page to its original state
     */
    public void resetPage(){
        paymentMethodButtonGroup.clearSelection();
        paymentMethodSelected = false;
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return checkOutPanel;
    }
}
