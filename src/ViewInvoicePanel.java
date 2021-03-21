import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ViewInvoicePanel extends JPanel
{
    JComboBox invoicePicker;
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
        this.add(new JPanel());

    }
    public void updatePanel()
    {
        try
        {
            this.remove(1);
            this.add(new InvoiceDisplayPanel(Integer.parseInt(String.valueOf(invoicePicker.getSelectedItem().toString().charAt(0)))));
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
    class InvoiceDisplayPanel extends JPanel
    {
       public InvoiceDisplayPanel(int invoiceId)
       {
           this.setPreferredSize(new Dimension(760,430));
           String[] tabNames = new String[]{"ProductName","SingleItemPrice","Quantity"};
           JTable test = new JTable(Retrive.fetchProductList(invoiceId),tabNames);
           this.add(new JScrollPane(test));

       }
    }
}
