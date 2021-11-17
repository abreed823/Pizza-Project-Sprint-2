import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SidesPage {
    private JButton logOutButton;
    private JPanel panelSides;
    private JCheckBox breadSticks$400CheckBox;
    private JCheckBox breadBites$200CheckBox;
    private JCheckBox chocolateChipCookie$4CheckBox;
    private JButton backButton;
    private JButton addToCartButton;

    public SidesPage() {
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
    }

    public JPanel getPanel(){
        return panelSides;
    }
}
