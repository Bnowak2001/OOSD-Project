import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * This class is used to create a panel for creating a new invoice
 * and adding new products to existing invoices
 */
public class CreateInvoice extends JPanel
{
    JComboBox customers = new JComboBox();
    JComboBox items = new JComboBox();
    JComboBox invoicePicker = new JComboBox();
    JTextField invoiceDate = new JTextField();
    JSpinner quantity = new JSpinner();

    /**
     * This is the default constructor it creates a Jpanel for creating invoices and adding items to them
     */
    public CreateInvoice()
    {
        String[][] customerArray = Retrive.fetchCustomers();
        String[][] productArray = Retrive.fetchProducts();
        String[][] invoiceArray = Retrive.fetchInvoiceCustomer();
        int i;
        ButtonListener buttonListener = new ButtonListener();
        this.setPreferredSize(new Dimension(800,500));
        this.setBackground(Color.lightGray);

        JPanel invoice = new JPanel();
        invoice.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        invoice.setPreferredSize(new Dimension(770,220));
        invoice.setLayout(new GridLayout(3,2,10,40));


        invoice.add(new JLabel("Select Customer: "));
        for(i=0;i<customerArray.length;i++)
        {
            String temp;
            temp = customerArray[i][0]+" : "+customerArray[i][1];
            customers.addItem(temp);
        }
        invoice.add(customers);

        invoice.add(new JLabel("Enter Invoice Date: "));
        invoiceDate.setToolTipText("Format: dd-mm-yyyy");
        invoice.add(invoiceDate);
        JButton button = new JButton("Create Invoice");
        button.addActionListener(buttonListener);
        invoice.add(button);


        this.add(invoice);

        JPanel addItem = new JPanel();
        addItem.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        addItem.setPreferredSize(new Dimension(770,250));
        addItem.setLayout(new GridLayout(4,2,10,30));
        addItem.add(new JLabel("Select Invoice"));
        for(i=0;i<invoiceArray.length;i++)
        {
            String temp;
            temp = invoiceArray[i][0]+" "+invoiceArray[i][1]+" "+invoiceArray[i][2];
            invoicePicker.addItem(temp);
        }
        addItem.add(invoicePicker);

        addItem.add(new JLabel("Select Product"));
        for(i=0;i<productArray.length;i++)
        {
            String temp;
            temp = productArray[i][0]+" : "+productArray[i][1];
            items.addItem(temp);
        }
        addItem.add(items);
        addItem.add(new JLabel("Select Quantity"));
        addItem.add(quantity);
        button = new JButton("Add Item");
        button.addActionListener(buttonListener);
        addItem.add(button);
        this.add(addItem);
    }

    /**
     * This class is provides a lister to the buttons in the create invoice panel
     */
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = e.getActionCommand();
            JButton b = (JButton) e.getSource();
            JFrame f = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());

            if(buttonLabel.equals("Create Invoice"))
            {
                try {
                    Date date = new SimpleDateFormat("dd-MM-yyyy").parse(invoiceDate.getText());
                    int customerId = Integer.parseInt(customers.getSelectedItem().toString().substring(0,customers.getSelectedItem().toString().indexOf(" ")));
                    Create.invoice(customerId,date);
                    f.getContentPane().remove(1);
                    f.getContentPane().add(new CreateInvoice());
                    f.revalidate();
                }
                catch (ParseException ex)
                {
                    ex.printStackTrace();
                }
            }
            else if(buttonLabel.equals("Add Item"))
            {
                int temp1 = Integer.parseInt(invoicePicker.getSelectedItem().toString().substring(0,invoicePicker.getSelectedItem().toString().indexOf(" ")));
                int temp2 = Integer.parseInt(items.getSelectedItem().toString().substring(0,items.getSelectedItem().toString().indexOf(" ")));
                Create.invoicedProduct(temp1,temp2,(Integer) quantity.getValue());
            }
        }
    }
}
