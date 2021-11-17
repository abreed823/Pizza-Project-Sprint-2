import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartOrderPage {
    private JPanel panelStartOrder;
    private JButton logOutButton;
    private JButton pizzaButton;
    private JButton sidesButton;
    private JButton drinksButton;
    private JButton viewCartButton;
    private JButton backButton;

    public StartOrderPage() {
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
                Main.showCardLayout("customerWelcome");
            }
        });
    }

    public JPanel getPanel(){
        return panelStartOrder;
    }
}
