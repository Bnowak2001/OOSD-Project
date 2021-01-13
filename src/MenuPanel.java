import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel implements ActionListener
{
    JButton newCustomer;
    JButton viewCustomers;
    JButton newAccount;
    JButton viewAccounts;

    MenuPanel()
    {
        JLabel menuPanel = new JLabel("Menu Panel");
        menuPanel.setFont(new Font("SansSerif", Font.BOLD, 30));

        JLabel customers = new JLabel("Customers");
        menuPanel.setFont(new Font("SansSerif", Font.BOLD, 30));

        this.setPreferredSize(new Dimension(275,750));
        this.setBackground(Color.gray);
        this.setLayout(new FlowLayout());
        this.add(menuPanel);
        this.add(customers);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
