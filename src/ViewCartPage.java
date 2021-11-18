import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewCartPage {
    private JButton logOutButton;
    private JPanel panelPayCard;
    private JButton continueButton;
    private JButton backButton;

    public ViewCartPage() {
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
        continueButton.addActionListener(new ActionListener() {
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
        return panelPayCard;
    }
}
