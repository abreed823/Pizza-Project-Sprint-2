import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;

public class LoginPageExample extends JPanel implements ActionListener {

    private JButton buttonLogin = new JButton("Login");
    private JButton buttonReset = new JButton("Reset");
    private JTextField fieldUserID = new JTextField();
    private JPasswordField fieldUserPassword = new JPasswordField();
    private JLabel labelUserID = new JLabel("userID:");
    private JLabel labelUserPassword = new JLabel("password:");
    private JLabel labelMessage = new JLabel("This is the message label");
    private HashMap<String, String> loginInfo = new HashMap<String,String>();

    LoginPageExample(){
        //HashMap<String, String> loginInfoOriginal
        //loginInfo = loginInfoOriginal;

        setLayout(null);
        labelUserID.setBounds(50,100,75,25);
        labelUserPassword.setBounds(50,150,75,25);

        labelMessage.setBounds(125,250,250,35);
        labelMessage.setFont(new Font(null,Font.ITALIC,25));

        fieldUserID.setBounds(125,100,200,25);
        fieldUserPassword.setBounds(125,150,200,25);

        buttonLogin.setBounds(125,200,100,25);
        buttonLogin.setFocusable(false);
        buttonLogin.addActionListener(this);

        buttonReset.setBounds(225,200,100,25);
        buttonReset.setFocusable(false);
        buttonReset.addActionListener(this);

        add(labelUserID);
        add(labelUserPassword);
        //add(labelMessage);
        add(fieldUserID);
        add(fieldUserPassword);
        add(buttonLogin);
        add(buttonReset);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buttonReset){
            fieldUserID.setText("");
            fieldUserPassword.setText("");
        }

        if(e.getSource() == buttonLogin){
            String userID = fieldUserID.getText();
            String password = String.valueOf(fieldUserPassword.getPassword());

//            if(loginInfo.containsKey(userID)){
//                if(loginInfo.get(userID).equals(password)){
//                    messageLabel
//                }
//            }
        }
    }
}
