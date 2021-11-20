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
    private JButton cancelButton;
    private JButton addToCartButton;
    private JLabel itemTotalLabel;
    private JLabel cartSubtotalLabel;
    private JLabel errorMessageLabel;

    private ArrayList<JCheckBox> checkBoxes;

    private double sidesPrice;
    private String totalPrice;

    public SidesPage() {
        checkBoxes = new ArrayList<JCheckBox>();
        checkBoxes.add(breadBitesCheckBox);
        checkBoxes.add(breadSticksCheckBox);
        checkBoxes.add(cookieCheckBox);

        cancelButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                resetPage();
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
                if(!sidesAreSelected()){
                    errorMessageLabel.setText("*Please make all required selections.");
                }else {
                    resetPage();
                    Main.showCardLayout("startOrder");
                }
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
                resetPage();
                Main.showCardLayout("welcome");
            }
        });
        breadSticksCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSidesPrice(breadSticksCheckBox, 4);
            }
        });
        breadBitesCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSidesPrice(breadBitesCheckBox, 2);
            }
        });
        cookieCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                updateSidesPrice(cookieCheckBox, 4);
            }
        });
    }

    public void updateSidesPrice(JCheckBox box, double itemPrice){
        if(box.isSelected()){
            sidesPrice += itemPrice;
        }else{
            sidesPrice -= itemPrice;
        }
        totalPrice = String.format("%.2f",sidesPrice);
        itemTotalLabel.setText("Item Total: $" + totalPrice);
    }

    public boolean sidesAreSelected(){
        for(JCheckBox box: checkBoxes){
            if(box.isSelected()){
                return true;
            }
        }
        return false;
    }

    public void resetPage(){
        for(JCheckBox checkBox: checkBoxes){
            checkBox.setSelected(false);
        }

        sidesPrice = 0;
        itemTotalLabel.setText("Item Total: $0.00");

        errorMessageLabel.setText("*Required");
    }

    public JPanel getPanel(){
        return panelSides;
    }
}
