import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;

public class CreateAccountPage {
    private JFormattedTextField firstNameTextField;
    private JFormattedTextField lastNameTextField;
    private JFormattedTextField phoneNumberTextField;
    private JFormattedTextField addressTextField;
    private JButton backButton;
    private JButton createButton;
    private JPanel panelCreateAccount;
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;
    private JLabel errorMessageLabel;

    public CreateAccountPage() {
        MaskFormatter phoneNumFormat;
        try {
             phoneNumFormat = new MaskFormatter("###-###-####");
             phoneNumFormat.setValidCharacters("0123456789");
             phoneNumFormat.setPlaceholderCharacter('#');
             phoneNumFormat.install(phoneNumberTextField);
        } catch (ParseException e) {
             e.printStackTrace();
        }

        backButton.addActionListener(new ActionListener() {
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
        createButton.addActionListener(new ActionListener() {
            /**
             * Invoked when an action occurs.
             *
             * @param e the event to be processed
             */
            @Override
            public void actionPerformed(ActionEvent e) {
                if(firstNameTextField.getText().equals("") || lastNameTextField.getText().equals("")
                || phoneNumberTextField.getText().equals("") || addressTextField.getText().equals("")
                || String.valueOf(passwordField.getPassword()).equals("")
                || String.valueOf(confirmPasswordField.getPassword()).equals("")){
                    errorMessageLabel.setText("Please fill out all text fields.");
                }else if(!String.valueOf(passwordField.getPassword()).equals(String.valueOf(confirmPasswordField.getPassword()))){
                    errorMessageLabel.setText("Your passwords do not match.");
                }else if(true){
                    firstNameTextField.setText("");

                }else {
                    Main.addLogin(phoneNumberTextField.getText(), String.valueOf(passwordField.getPassword()));
                    firstNameTextField.setText("");
                    lastNameTextField.setText("");
                    phoneNumberTextField.setText("");
                    addressTextField.setText("");
                    passwordField.setText("");
                    confirmPasswordField.setText("");
                    errorMessageLabel.setText("");
                    Main.showCardLayout("customerWelcome");
                }
            }
        });
    }

    public JPanel getPanel(){
        return panelCreateAccount;
    }
}
