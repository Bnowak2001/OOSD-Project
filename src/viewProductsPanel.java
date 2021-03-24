import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This class is used to create a product viewing panel
 */
public class viewProductsPanel extends JPanel
{
    JTable products;
    JTextField productIdField;
    JTextField productNameField;
    JTextField productDescriptionField;
    JTextField unitPriceField;

    /**
     * The default constructor creates a view product panel
     */
    viewProductsPanel()
    {
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createEmptyBorder(10,10,10,10));
        productIdField= new JTextField();
        productIdField.setEditable(false);

        productNameField= new JTextField();
        productDescriptionField = new JTextField();
        unitPriceField= new JTextField();

        ListListener listListener = new ListListener();
        ButtonListener buttonListener = new ButtonListener();

        setPreferredSize(new Dimension(800,500));
        setLayout(new GridLayout(2,1,20,20));

        String[] colNames= new String[]{"Product ID","Product Name","Product Description","Unit Price"};
        products = new JTable(Retrive.fetchProducts(),colNames);
        products.getSelectionModel().addListSelectionListener(listListener);


        JScrollPane tablepane = new JScrollPane(products);
        add(tablepane);


        JPanel p = new JPanel();
        p.setLayout(new GridLayout(5,2,0,5));
        p.setBackground(Color.lightGray);
        p.add(new JLabel("Product ID: "));
        p.add(productIdField);
        p.add(new JLabel("Product Name: "));
        p.add(productNameField);
        p.add(new JLabel("Product Description: "));
        p.add(productDescriptionField);
        p.add(new JLabel("Product Price: "));
        p.add(unitPriceField);
        JButton button = new JButton("Delete Record");
        button.addActionListener(buttonListener);
        p.add(button);
        button = new JButton("Update Record");
        button.addActionListener(buttonListener);
        p.add(button);
        add(p);

    }

    /**
     * This class gives a listener to the jtable on the view products panel
     * if a row on the table is clicked it will populate textboxes on the editing panel
     */
    class ListListener implements ListSelectionListener
    {
        @Override
        public void valueChanged(ListSelectionEvent e)
        {
            ListSelectionModel lsm = (ListSelectionModel) e.getSource();
            productIdField.setText((String) products.getValueAt(lsm.getAnchorSelectionIndex(), 0));
            productNameField.setText((String) products.getValueAt(lsm.getAnchorSelectionIndex(), 1));
            productDescriptionField.setText((String) products.getValueAt(lsm.getAnchorSelectionIndex(), 2));
            unitPriceField.setText((String) products.getValueAt(lsm.getAnchorSelectionIndex(), 3));
        }
    }

    /**
     * This class is used to provide a listener to the buttons on view products panel
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
                    InputVerifier.verifyProduct(productNameField.getText(),productDescriptionField.getText(),unitPriceField.getText());
                    Update.Product(Integer.parseInt(productIdField.getText()),productNameField.getText(),productDescriptionField.getText(),Double.parseDouble(unitPriceField.getText()));
                    f.getContentPane().remove(1);
                    f.getContentPane().add(new viewProductsPanel());
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
               int dialogResult = JOptionPane.showConfirmDialog(f,"Are you sure you want to delete this product it will also remove this product from all invoices");
               if(dialogResult==0)
               {
                   Delete.product(Integer.parseInt(productIdField.getText()));
                   f.getContentPane().remove(1);
                   f.getContentPane().add(new viewProductsPanel());
                   f.revalidate();
               }
            }
        }
    }

}
