import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage {
    private JPanel panelWelcome;
    private JLabel labelWelcome;
    private JButton logInButton;
    private JButton createAccountButton;

    public WelcomePage() {
        logInButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                //todo-reset this button to link back to the log in page
                Main.showCardLayout("startOrder");
            }
        });
        createAccountButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("createAccount");
            }
        });
    }

    public JPanel getPanel(){
        return panelWelcome;
    }
}
