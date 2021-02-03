import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuPanel extends JPanel
{
    MenuPanel()
    {
        this.setPreferredSize(new Dimension(150,400));
        this.setBackground(Color.gray);
        this.setLayout(new GridLayout(10,1));
        this.add(new JLabel("Menu Bar"));
        ButtonListener buttonListener = new ButtonListener();

        JButton b = new JButton("Add Customer");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("View Customers");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("Add Account");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("View Accounts");
        this.add(b);
        b.addActionListener(buttonListener);
    }


    class ButtonListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = e.getActionCommand();
            JButton b = (JButton) e.getSource();
            if(buttonLabel.equals("Add Customer"))
            {
                b.getParent().getParent().remove(1);
                b.getParent().getParent().add(new CreateCustomerPanel());
                b.getParent().getParent().revalidate();
            }
            else if(buttonLabel.equals("View Customers"))
            {
                b.getParent().getParent().remove(1);
                b.getParent().getParent().add(new ViewCustomersPanel());
                b.getParent().getParent().revalidate();
            }
        }
    }

}
