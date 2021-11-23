/**
 * The functionality and display for the Receipt page
 *
 * @author Team 2
 */

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptPage {
    private JButton logOutButton;
    private JPanel receiptPanel;
    private JButton printButton;
    private JButton exitButton;
    private JTable receiptTable;

    /**
     * Constructor
     */
    public ReceiptPage() {
        exitButton.addActionListener(new ActionListener() {
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
        printButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("print");
            }
        });
    }

    /**
     * Returns the JPanel to the Main class
     * @return the panel to return
     */
    public JPanel getPanel(){
        return receiptPanel;
    }
}
