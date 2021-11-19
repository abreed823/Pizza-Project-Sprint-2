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

    private int toppingsCounter;

    private ArrayList<JCheckBox> boxesToDisable = new ArrayList<JCheckBox>();
    private boolean disabled;

    public PizzaPage() {
        boxesToDisable.add(pepperoniCheckBox);
        boxesToDisable.add(onionCheckBox);
        boxesToDisable.add(mushroomCheckBox);
        boxesToDisable.add(hamCheckBox);
        boxesToDisable.add(sausageCheckBox);
        boxesToDisable.add(pineappleCheckBox);
        boxesToDisable.add(greenPepperCheckBox);
        boxesToDisable.add(tomatoCheckBox);
        boxesToDisable.add(extraCheeseCheckBox);
        disabled = false;
        toppingsCounter = 0;

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

    public void toggleCheckBox(JCheckBox box){
        if(box.isSelected()){
            boxesToDisable.remove(box);
            changeCounter(true);
        }else{
            boxesToDisable.add(box);
            changeCounter(false);
        }
    }

    public void changeCounter(boolean add){
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

    public JPanel getPanel(){
        return panelPizza;
    }
}
