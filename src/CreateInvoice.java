import javax.swing.*;
import java.awt.*;

public class CreateInvoice extends JPanel
{
    JComboBox customers = new JComboBox();
    JComboBox items = new JComboBox();
    JComboBox invoicePicker = new JComboBox();
    public CreateInvoice()
    {
        this.setPreferredSize(new Dimension(800,500));
        this.setBackground(Color.lightGray);

        JPanel invoice = new JPanel();
        invoice.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        invoice.setPreferredSize(new Dimension(770,220));
        invoice.setLayout(new GridLayout(3,2,10,40));
        invoice.add(new JLabel("Select Customer: "));
        customers.addItem("test1");
        customers.addItem("test2");
        customers.addItem("test3");
        invoice.add(customers);
        invoice.add(new JLabel("Enter Invoice Date: "));
        invoice.add(new JTextField());
        invoice.add(new JButton("Create Invoice"));
        invoice.add(new JButton("Clear"));
        this.add(invoice);

        JPanel addItem = new JPanel();
        addItem.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        addItem.setPreferredSize(new Dimension(770,250));
        addItem.setLayout(new GridLayout(4,2,10,30));
        addItem.add(new JLabel("Select Invoice"));
        invoicePicker.addItem("1");
        invoicePicker.addItem("2");
        invoicePicker.addItem("3");
        addItem.add(invoicePicker);
        addItem.add(new JLabel("Select Product"));
        items.addItem("Hammer");
        items.addItem("Drill");
        items.addItem("Screw Driver");
        addItem.add(items);
        addItem.add(new JLabel("Select Quantity"));
        addItem.add(new JSpinner());
        addItem.add(new JButton("Add Item"));
        this.add(addItem);
    }
}
