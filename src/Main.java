import javax.swing.*;
import java.awt.*;

public class Main {
    private JFrame frame = new JFrame("Card Layout Test");
    private static JPanel contentPanel = new JPanel();
    private static CardLayout cl = new CardLayout(20, 20);
    private IDsandPasswords idsandPasswords = new IDsandPasswords();
//    private WelcomePage welcomePage = new WelcomePage();
//    private LoginPageExample loginPage = new LoginPageExample();

    //private LoginPageExample loginPage = new LoginPageExample(idsandPasswords.getLoginInfo());

    private WelcomePage welcomePage = new WelcomePage();
    private LoginPage login = new LoginPage(idsandPasswords.getLoginInfo());
    private CreateAccountPage createAccount = new CreateAccountPage();
    private CustomerWelcomePage customerWelcome = new CustomerWelcomePage();
    private StartOrderPage startOrder = new StartOrderPage();

    private JPanel welcomePagePanel = welcomePage.getPanel();
    private JPanel loginPagePanel = login.getPanel();
    private JPanel createAccountPanel = createAccount.getPanel();
    private JPanel customerWelcomePanel = customerWelcome.getPanel();
    private JPanel startOrderPanel = startOrder.getPanel();

    public Main(){
        contentPanel.setLayout(cl);
        contentPanel.add(welcomePagePanel, "welcome");
        contentPanel.add(loginPagePanel, "login");
        contentPanel.add(createAccountPanel, "createAccount");
        contentPanel.add(customerWelcomePanel,"customerWelcome");
        contentPanel.add(startOrderPanel, "startOrder");
        cl.show(contentPanel, "welcome");

//        , BorderLayout.CENTER
        frame.add(contentPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        //frame.setLocationRelativeTo(null);
        frame.setPreferredSize(new Dimension(1280,720));
        frame.pack();
        frame.setVisible(true);
    }

    //Allows the card layout to be controlled by other objects/pages
    public static void showCardLayout(String cardName){
        cl.show(contentPanel, cardName);
    }


    public static void main(String[] args){
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Main();
            }
        });
    }
}
