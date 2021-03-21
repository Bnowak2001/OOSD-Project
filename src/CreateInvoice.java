import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateInvoice extends JPanel
{
    JComboBox customers = new JComboBox();
    JComboBox items = new JComboBox();
    JComboBox invoicePicker = new JComboBox();
    JTextField invoiceDate = new JTextField();
    JSpinner quantity = new JSpinner();
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
        invoiceDate.setToolTipText("Format: dd/mm/yyyy");
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
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = e.getActionCommand();
            JButton b = (JButton) e.getSource();

            if(buttonLabel.equals("Create Invoice"))
            {
                try {
                    Date date = new SimpleDateFormat("dd/mm/yy").parse(invoiceDate.getText());
                    Create.invoice(Integer.parseInt(String.valueOf(customers.getSelectedItem().toString().charAt(0))),date);
                } catch (ParseException ex) {
                    ex.printStackTrace();
                }
            }
            else if(buttonLabel.equals("Add Item"))
            {
                int temp1 = Integer.parseInt(String.valueOf(invoicePicker.getSelectedItem().toString().charAt(0)));
                int temp2 = Integer.parseInt(String.valueOf(items.getSelectedItem().toString().charAt(0)));
                Create.invoicedProduct(temp1,temp2,(Integer) quantity.getValue());
            }
            }
        }
}
