import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class SidesPage {
    private JButton logOutButton;
    private JPanel panelSides;
    private JCheckBox breadSticksCheckBox;
    private JCheckBox breadBitesCheckBox;
    private JCheckBox cookieCheckBox;
    private JButton backButton;
    private JButton addToCartButton;

    private ArrayList<JCheckBox> checkBoxes = new ArrayList<JCheckBox>();

    public SidesPage() {
        checkBoxes.add(breadBitesCheckBox);
        checkBoxes.add(breadSticksCheckBox);
        checkBoxes.add(cookieCheckBox);

        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                resetCheckBoxes();
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
                resetCheckBoxes();
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
                resetCheckBoxes();
                Main.showCardLayout("welcome");
            }
        });
    }

    public void resetCheckBoxes(){
        for(JCheckBox checkBox: checkBoxes){
            checkBox.setSelected(false);
        }
    }

    public JPanel getPanel(){
        return panelSides;
    }
}
