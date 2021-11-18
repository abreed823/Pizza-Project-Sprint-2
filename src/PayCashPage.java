import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayCashPage {
    private JButton logOutButton;
    private JPanel panelPayCash;
    private JButton backButton;
    private JButton continueButton;

    public PayCashPage() {
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

    public JPanel getPanel(){
        return panelPayCash;
    }
}
