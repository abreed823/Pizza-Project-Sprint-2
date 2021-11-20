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

    private ButtonGroup sizesButtonGroup;
    private ButtonGroup crustButtonGroup;

    private int toppingsCounter;

    private ArrayList<JCheckBox> boxesToDisable = new ArrayList<JCheckBox>();
    private boolean disabled;

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

    public void resetCheckBoxes(){
        addCheckBoxes();
        enableCheckBoxes();
        toppingsCounter = 0;
        for(JCheckBox box: boxesToDisable){
            box.setSelected(false);
        }
    }

    public void resetRadioButtons(){
        sizesButtonGroup.clearSelection();
        crustButtonGroup.clearSelection();
    }

    public JPanel getPanel(){
        return panelPizza;
    }
}
