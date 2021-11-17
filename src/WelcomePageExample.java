import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePageExample extends JPanel {

    private JLabel labelTest = new JLabel("WELCOME");
    private JButton buttonTest = new JButton("Test");

    public WelcomePageExample(){
        setLayout(null);

        labelTest.setFont(new Font("Calibri (Body)", Font.BOLD, 60));
        labelTest.setBounds(640,360,10,10);

        add(labelTest);
        //add(buttonTest);

        buttonTest.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Main.showCardLayout("login");

            }
        });
    }
}
