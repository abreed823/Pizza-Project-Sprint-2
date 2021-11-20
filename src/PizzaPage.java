import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class PizzaPage {
    private JButton logOutButton;
    private JPanel panelPizza;
    private JRadioButton smallRadioButton;
    private JRadioButton mediumRadioButton;
    private JRadioButton largeRadioButton;
    private JRadioButton xLargeRadioButton;
    private JCheckBox pepperoniCheckBox;
    private JCheckBox onionCheckBox;
    private JCheckBox mushroomCheckBox;
    private JCheckBox hamCheckBox;
    private JCheckBox sausageCheckBox;
    private JCheckBox pineappleCheckBox;
    private JCheckBox greenPepperCheckBox;
    private JCheckBox tomatoCheckBox;
    private JCheckBox extraCheeseCheckBox;
    private JRadioButton originalRadioButton;
    private JRadioButton panRadioButton;
    private JRadioButton thinRadioButton;
    private JButton backButton;
    private JButton addToCartButton;
    private JLabel itemTotalLabel;
    private JLabel cartSubtotalLabel;

    private ButtonGroup sizesButtonGroup;
    private ButtonGroup crustButtonGroup;

    private int toppingsCounter;

    private ArrayList<JCheckBox> boxesToDisable = new ArrayList<JCheckBox>();
    private boolean disabled;

    private double sizePrice;
    private String itemTotalPrice;

    public PizzaPage() {

        addCheckBoxes();
        disabled = false;
        toppingsCounter = 0;

        sizesButtonGroup = new ButtonGroup();
        sizesButtonGroup.add(smallRadioButton);
        sizesButtonGroup.add(mediumRadioButton);
        sizesButtonGroup.add(largeRadioButton);
        sizesButtonGroup.add(xLargeRadioButton);

       crustButtonGroup = new ButtonGroup();
       crustButtonGroup.add(originalRadioButton);
       crustButtonGroup.add(thinRadioButton);
       crustButtonGroup.add(panRadioButton);

        logOutButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                resetRadioButtons();
                resetCheckBoxes();
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
                resetRadioButtons();
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
                resetRadioButtons();
                resetCheckBoxes();
                Main.showCardLayout("startOrder");
            }
        });

        pepperoniCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(pepperoniCheckBox);
            }
        });
        hamCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(hamCheckBox);
            }
        });
        greenPepperCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(greenPepperCheckBox);
            }
        });
        onionCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(onionCheckBox);
            }
        });
        sausageCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(sausageCheckBox);
            }
        });
        tomatoCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(tomatoCheckBox);
            }
        });
        mushroomCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(mushroomCheckBox);
            }
        });
        pineappleCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(pineappleCheckBox);
            }
        });
        extraCheeseCheckBox.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                toggleCheckBox(extraCheeseCheckBox);
            }
        });
        smallRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizePrice(4.00);
            }
        });
        mediumRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizePrice(6.00);
            }
        });
        largeRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizePrice(8.00);
            }
        });
        xLargeRadioButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                setSizePrice(10.00);
            }
        });
    }

    public void addCheckBoxes(){
        boxesToDisable.clear();
        boxesToDisable.add(pepperoniCheckBox);
        boxesToDisable.add(onionCheckBox);
        boxesToDisable.add(mushroomCheckBox);
        boxesToDisable.add(hamCheckBox);
        boxesToDisable.add(sausageCheckBox);
        boxesToDisable.add(pineappleCheckBox);
        boxesToDisable.add(greenPepperCheckBox);
        boxesToDisable.add(tomatoCheckBox);
        boxesToDisable.add(extraCheeseCheckBox);
    }

    public void toggleCheckBox(JCheckBox box){
        if(box.isSelected()){
            boxesToDisable.remove(box);
            changeToppingsCounter(true);
        }else{
            boxesToDisable.add(box);
            changeToppingsCounter(false);
        }
    }

    public void changeToppingsCounter(boolean add){
        if(add){
            toppingsCounter++;
        }else{
            toppingsCounter--;
        }

        if(toppingsCounter == 4){
            disableCheckBoxes();
        }else if(disabled){
            enableCheckBoxes();
        }
    }

    public void disableCheckBoxes(){
        for(JCheckBox box: boxesToDisable){
            box.setEnabled(false);
        }
        disabled = true;
    }

    public void enableCheckBoxes(){
        for(JCheckBox box: boxesToDisable){
            box.setEnabled(true);
        }
        disabled = false;
    }

    public void setSizePrice(double sizePrice){
        this.sizePrice = sizePrice;
        updateItemTotal(this.sizePrice);
    }

    public void updateItemTotal(double sizePrice){
        itemTotalPrice = String.format("%.2f",sizePrice);
        itemTotalLabel.setText("Item Total: $" + itemTotalPrice);
    }

    //todo - put all of this into one function called reset page
    //reasoning - these are all ONLY called when we exit the page
    public void resetCheckBoxes(){
        //Resets checkboxes
        addCheckBoxes();
        enableCheckBoxes();
        toppingsCounter = 0;
        for(JCheckBox box: boxesToDisable){
            box.setSelected(false);
        }

        //resetsRadioButtons
        sizesButtonGroup.clearSelection();
        crustButtonGroup.clearSelection();

        //resets itemTotalLabel
        itemTotalLabel.setText("Item Total: $0.00");
    }

    public void resetRadioButtons(){
        sizesButtonGroup.clearSelection();
        crustButtonGroup.clearSelection();
    }

    public JPanel getPanel(){
        return panelPizza;
    }
}
