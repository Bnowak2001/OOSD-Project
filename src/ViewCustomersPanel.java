import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to create a new view customers panel
 */
public class ViewCustomersPanel extends JPanel
{
    JTable customers;
    JTextField idField;
    JTextField nameField;
    JTextField emailField;
    JTextField addressField;
    JTextField phoneNumberField;

    /**
     * The default constructor creates a new view customer panel
     */
    public ViewCustomersPanel() {

        idField= new JTextField();
        idField.setEditable(false);

        nameField= new JTextField();
        emailField= new JTextField();
        addressField= new JTextField();
        phoneNumberField= new JTextField();


        this.setPreferredSize(new Dimension(800,500));
        this.setLayout(new GridLayout(2,1,10,10));
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));

        ListListener listListener = new ListListener();
        ButtonListener buttonListener = new ButtonListener();

        String[] colNames= new String[]{"Customer ID","Name","Address","Email","Phone Number"};
        customers = new JTable(Retrive.fetchCustomers(),colNames);
        customers.getSelectionModel().addListSelectionListener(listListener);


        JScrollPane tablepane = new JScrollPane(customers);
        add(tablepane);


        JPanel p = new JPanel();
        p.setLayout(new GridLayout(6,2,0,5));
        p.setBackground(Color.lightGray);
        p.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
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

    /**
     * This class gives a listener to the jtable on the view customers panel
     * if a row on the table is clicked it will populate textboxes on the editing panel
     */
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

    /**
     * The listener class for the buttons on the view customers panel
     */
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e)
        {
            String buttonLabel = e.getActionCommand();
            JFrame f = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());

            if(buttonLabel.equals("Update Record"))
            {
                try
                {
                    InputVerifier.verifyCustomer(nameField.getText(),addressField.getText(),phoneNumberField.getText(),emailField.getText());
                    Update.Customer(Integer.parseInt(idField.getText()),nameField.getText(),addressField.getText(),emailField.getText(),phoneNumberField.getText());
                    f.getContentPane().remove(1);
                    f.getContentPane().add(new ViewCustomersPanel());
                    f.revalidate();
                }
                catch (MyInvalidInputException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(buttonLabel.equals("Delete Record"))
            {
                int dialogResult = JOptionPane.showConfirmDialog(f,"Are you sure you want to delete this customer it will remove all invoices associated with this customer");
                if(dialogResult==0)
                {
                    Delete.customer(Integer.parseInt(idField.getText()));
                    f.getContentPane().remove(1);
                    f.getContentPane().add(new ViewCustomersPanel());
                    f.revalidate();
                }
            }
        }
    }
}
