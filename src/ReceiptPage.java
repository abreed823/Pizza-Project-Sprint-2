import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReceiptPage {
    private JButton logOutButton;
    private JPanel panelReceipt;
    private JButton printButton;
    private JButton exitButton;

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

    public JPanel getPanel(){
        return panelReceipt;
    }
}
