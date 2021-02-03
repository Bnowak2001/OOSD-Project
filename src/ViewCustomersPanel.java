import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class ViewCustomersPanel extends JPanel
{
    JTable customers;
    JTextField idField;
    JTextField nameField;
    JTextField emailField;
    JTextField addressField;
    JTextField phoneNumberField;

    public ViewCustomersPanel() {

        idField= new JTextField();
        idField.setEditable(false);

        nameField= new JTextField();
        emailField= new JTextField();
        addressField= new JTextField();
        phoneNumberField= new JTextField();


        this.setPreferredSize(new Dimension(600,400));
        this.setLayout(new FlowLayout());
        this.setBackground(Color.lightGray);

        ListListener listListener = new ListListener();
        ButtonListener buttonListener = new ButtonListener();

        String[] colNames= new String[]{"CustomerID","NAME","ADDRESS","Email","PHONENUMBER"};
        customers = new JTable(Retrive.fetchCustomers(),colNames);
        customers.getSelectionModel().addListSelectionListener(listListener);


        JScrollPane tablepane = new JScrollPane(customers);
        tablepane.setPreferredSize(new Dimension( 550,150));
        add(tablepane);


        JPanel p = new JPanel();
        p.setPreferredSize(new Dimension(550,225));
        p.setLayout(new GridLayout(6,2));
        p.add(new JLabel("Customer ID: "));
        p.add(idField);
        p.add(new JLabel("Customer Name: "));
        p.add(nameField);
        p.add(new JLabel("Customer Address: "));
        p.add(addressField);
        p.add(new JLabel("Customer Email: "));
        p.add(emailField);
        p.add(new JLabel("Customer Phonenumber: "));
        p.add(phoneNumberField);

        JButton button = new JButton("Delete Record");
        button.addActionListener(buttonListener);
        p.add(button);
        button = new JButton("Update Record");
        button.addActionListener(buttonListener);
        p.add(button);
        add(p);


    }


    class ListListener implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e) {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            idField.setText((String)customers.getValueAt(lsm.getAnchorSelectionIndex(),0));
            nameField.setText((String)customers.getValueAt(lsm.getAnchorSelectionIndex(),1));
            addressField.setText((String)customers.getValueAt(lsm.getAnchorSelectionIndex(),2));
            emailField.setText((String)customers.getValueAt(lsm.getAnchorSelectionIndex(),3));
            phoneNumberField.setText((String)customers.getValueAt(lsm.getAnchorSelectionIndex(),4));

        }
    }
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = e.getActionCommand();

            if(buttonLabel.equals("Update Record"))
            {
                Update.Customer(Integer.parseInt(idField.getText()),nameField.getText(),addressField.getText(),emailField.getText(),phoneNumberField.getText());

            }
            else if(buttonLabel.equals("Delete Record"))
            {
                Delete.customer(Integer.parseInt(idField.getText()));
            }
        }
    }
}
