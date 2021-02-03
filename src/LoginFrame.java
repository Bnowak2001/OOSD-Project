import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;



public class LoginFrame extends JFrame implements ActionListener
{
    JTextField usernameInput;
    JTextField passwordInput;
    JButton button;


    public LoginFrame()
    {
         usernameInput = new JTextField();
         passwordInput = new JPasswordField();
        usernameInput.setPreferredSize(new Dimension(200,40));
        passwordInput.setPreferredSize(new Dimension(200,40));
        button = new JButton("Login");
        button.setPreferredSize(new Dimension(100,40));
        button.addActionListener(this);

        JPanel loginPanel = new JPanel();
        loginPanel.setPreferredSize(new Dimension(300,500));
        loginPanel.setBackground(Color.white);
        loginPanel.add(new JLabel(new ImageIcon("res/Login img1.jpg")));
        loginPanel.add(usernameInput);
        loginPanel.add(passwordInput);
        loginPanel.add(button);

        this.setTitle("Login");
        this.setVisible(true);
        this.setSize(new Dimension(400,600));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setLayout(new FlowLayout());
        this.add(loginPanel);
        this.pack();



    }
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==button)
        {
            // Account checker looks up the account details entered and returns a true if they are valid
           if(AccountChecker.accountMatch(usernameInput.getText(),passwordInput.getText()))
           {
               MainWindow mainWindow = new MainWindow();//The main window is opened
               this.dispose();//Login window is closed
           }
        }
    }
}
