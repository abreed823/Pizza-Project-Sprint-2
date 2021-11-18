import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PayCardPage {
    private JButton logOutButton;
    private JPanel panelPayCard;
    private JFormattedTextField formattedTextField1;
    private JFormattedTextField formattedTextField2;
    private JFormattedTextField formattedTextField3;
    private JFormattedTextField formattedTextField4;
    private JButton backButton;
    private JButton finishPayButton;

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

    public JPanel getPanel(){
        return panelPayCard;
    }
}
