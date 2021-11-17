import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPage {
    private JPanel panelLogIn;
    private JFormattedTextField formattedTextField1;
    private JButton backButton;
    private JButton logInButton;
    private JPasswordField passwordField1;
    private HashMap<String, String> loginInfo = new HashMap<String,String>();

    public LoginPage(HashMap<String, String> loginInfoOriginal) {
        loginInfo = loginInfoOriginal;
        backButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                formattedTextField1.setText("");
                passwordField1.setText("");
                Main.showCardLayout("welcome");
            }
        });
        logInButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                String userID = formattedTextField1.getText();
                String password = String.valueOf(passwordField1.getPassword());

                if(loginInfo.containsKey(userID)){
                    if(loginInfo.get(userID).equals(password)){
                        formattedTextField1.setText("");
                        passwordField1.setText("");
                        Main.showCardLayout("customerWelcome");
                    }
                }
            }
        });
    }

    public JPanel getPanel(){
        return panelLogIn;
    }
}
