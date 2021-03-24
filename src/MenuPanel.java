import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to create a menu side panel
 */
public class MenuPanel extends JPanel
{
    /**
     * This is the default constructor it creates a menu panel
     */
    MenuPanel()
    {
        this.setPreferredSize(new Dimension(150,500));
        this.setLayout(new GridLayout(10,1,1,8));
        this.setBackground(Color.GRAY);
        this.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
        JLabel l = new JLabel("Menu");
        l.setHorizontalAlignment(JLabel.CENTER);
        l.setForeground(Color.lightGray);
        this.add(l);
        ButtonListener buttonListener = new ButtonListener();

        JButton b = new JButton("Add Customer");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("View Customers");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("Add Product");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("View Products");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("Create Invoice");
        this.add(b);
        b.addActionListener(buttonListener);

        b = new JButton("View Invoice");
        this.add(b);
        b.addActionListener(buttonListener);
    }

    /**
     * This is the listener for the menu panel buttons
     */
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
            else if(buttonLabel.equals("Add Product"))
            {
                b.getParent().getParent().remove(1);
                b.getParent().getParent().add(new CreateProductPanel());
                b.getParent().getParent().revalidate();
            }
            else if(buttonLabel.equals("View Products"))
            {
                b.getParent().getParent().remove(1);
                b.getParent().getParent().add(new viewProductsPanel());
                b.getParent().getParent().revalidate();
            }
            else if(buttonLabel.equals("Create Invoice"))
            {
                b.getParent().getParent().remove(1);
                b.getParent().getParent().add(new CreateInvoice());
                b.getParent().getParent().revalidate();
            }
            else if(buttonLabel.equals("View Invoice"))
            {
                b.getParent().getParent().remove(1);
                b.getParent().getParent().add(new ViewInvoicePanel());
                b.getParent().getParent().revalidate();
            }
        }
    }

}
