import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateProductPanel extends JPanel
{
    JTextField productName = new JTextField(30);
    JTextField productDescription = new JTextField(30);
    JTextField unitPrice = new JTextField(30);

    CreateProductPanel()
    {
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");

        ButtonListener buttonListener = new ButtonListener();

        submit.addActionListener(buttonListener);
        clear.addActionListener(buttonListener);

        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createEmptyBorder(40,20,10,20));
        setPreferredSize(new Dimension(800,500));
        setLayout(new GridLayout(4,2,40,100));

        add(new JLabel("Product Name: "));
        add(productName);
        add(new JLabel("Product Description: "));
        add(productDescription);
        add(new JLabel("Unit Price: "));
        add(unitPrice);
        add(submit);
        add(clear);

    }




    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonLabel = e.getActionCommand();

            if(buttonLabel.equals("Submit"))
            {
                Create.product(productName.getText(),productDescription.getText(),Double.parseDouble(unitPrice.getText()));
            }
            else if(buttonLabel.equals("Clear"))
            {
                productName.setText("");
                productDescription.setText("");
                unitPrice.setText("");
            }
        }
    }
}
