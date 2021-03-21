import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInvoicePanel extends JPanel
{
    JComboBox invoicePicker;
    JButton deleteInvoice;
    public ViewInvoicePanel()
    {
        String[][] invoiceArray = Retrive.fetchInvoiceCustomer();
        this.setPreferredSize(new Dimension(800,500));
        this.setBackground(Color.lightGray);
        this.setLayout(new FlowLayout());
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        invoicePicker = new JComboBox();
        invoicePicker.setPreferredSize(new Dimension(760,30));
        SelectorListener selectorListener = new SelectorListener();
        invoicePicker.addActionListener(selectorListener);
        for(int i = 0; i < invoiceArray.length; i++)
        {
            String temp = invoiceArray[i][0]+" "+invoiceArray[i][1]+" "+invoiceArray[i][2];
            invoicePicker.addItem(temp);
        }
        this.add(invoicePicker);
        this.add(new JLabel(""));

        deleteInvoice= new JButton("Delete Selected Invoice");
        deleteInvoice.setPreferredSize(new Dimension(250,30));
    }
    public void updatePanel()
    {
        try
        {
            int invoiceId = Integer.parseInt(invoicePicker.getSelectedItem().toString().substring(0,invoicePicker.getSelectedItem().toString().indexOf(" ")));
            this.remove(1);
            this.add(new InvoiceDisplayPanel(invoiceId));
            this.add(deleteInvoice);
            this.revalidate();
        }
        catch (Exception e)
        {

        }
    }
    class SelectorListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent e)
        {
            updatePanel();
        }
    }
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = e.getActionCommand();
            if(buttonLabel.equals("Delete Selected Invoice"))
            {

            }
        }
    }


    class InvoiceDisplayPanel extends JPanel
    {
       public InvoiceDisplayPanel(int invoiceId)
       {
           this.setPreferredSize(new Dimension(760,410));
           Update.updateInvoiceValue(invoiceId);
           String[] invoiceDetails = Retrive.fetchInvoiceForDisplay(invoiceId);


           JPanel customerDetails = new JPanel();
           customerDetails.setPreferredSize(new Dimension(750,150));
           customerDetails.setLayout(new GridLayout(5,2,5,5));
           customerDetails.setBorder(BorderFactory.createEmptyBorder(0,10,10,10));
           customerDetails.add(new JLabel("For"));
           customerDetails.add(new JLabel("Total Invoice Price"));
           customerDetails.add(new JLabel(invoiceDetails[3]));
           customerDetails.add(new JLabel(invoiceDetails[2]));
           customerDetails.add(new JLabel(invoiceDetails[4]));
           customerDetails.add(new JLabel("Invoice Date"));
           customerDetails.add(new JLabel(invoiceDetails[5]));
           customerDetails.add(new JLabel(invoiceDetails[1]));
           customerDetails.add(new JLabel(invoiceDetails[6]));
           this.add(customerDetails);

           JPanel productList = new JPanel();
           productList.setLayout(new GridLayout(1,1));
           productList.setPreferredSize(new Dimension(750,250));
           String[] tabNames = new String[]{"ProductName","SingleItemPrice","Quantity"};
           JTable test = new JTable(Retrive.fetchProductList(invoiceId),tabNames);
           productList.add(new JScrollPane(test));
           this.add(productList);

       }
    }
}
