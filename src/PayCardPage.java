/**
 * The functionality and display for the Pay With Card page
 *
 * @author Team 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayCardPage {
    private JButton logOutButton;
    private JPanel payCardPanel;
    private JFormattedTextField nameTextField;
    private JFormattedTextField cardNumberTextField;
    private JFormattedTextField expDateTextField;
    private JFormattedTextField cvvTextField;
    private JButton backButton;
    private JButton finishPayButton;

    /**
     * Constructor
     */
    public PayCardPage() {
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
                Main.showCardLayout("checkOut");
            }
        });
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return payCardPanel;
    }
}
