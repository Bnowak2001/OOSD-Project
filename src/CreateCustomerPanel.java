import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateCustomerPanel extends JPanel
{
    JTextField name = new JTextField(30);
    JTextField address = new JTextField(30);
    JTextField phoneNumber= new JTextField(30);
    JTextField email= new JTextField(30);

    CreateCustomerPanel()
    {
        JButton submit = new JButton("Submit");
        JButton clear = new JButton("Clear");
        ButtonListener buttonListener = new ButtonListener();
        this.setBackground(Color.lightGray);
        this.setBorder(BorderFactory.createEmptyBorder(40,20,10,20));

        submit.addActionListener(buttonListener);
        clear.addActionListener(buttonListener);

        setPreferredSize(new Dimension(800,500));
        setLayout(new GridLayout(5,2,40,70));

        add(new JLabel("Customer Name: "));
        add(name);
        add(new JLabel("Customer Address: "));
        add(address);
        add(new JLabel("Customer Phone Number: "));
        add(phoneNumber);
        add(new JLabel("Customer Email: "));
        add(email);
        add(submit);
        add(clear);




    }
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonLabel = e.getActionCommand();
            JFrame f = (JFrame) SwingUtilities.getWindowAncestor((JButton) e.getSource());

            if(buttonLabel.equals("Submit"))
            {
                try
                {
                    InputVerifier.verifyCustomer(name.getText(),address.getText(),phoneNumber.getText(),email.getText());
                    Create.customer(name.getText(),address.getText(),email.getText(),phoneNumber.getText());
                }
                catch (MyInvalidInputException ex)
                {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(f,ex.getMessage(),"Error",JOptionPane.ERROR_MESSAGE);
                }
            }
            else if(buttonLabel.equals("Clear"))
            {
                name.setText("");
                address.setText("");
                phoneNumber.setText("");
                email.setText("");
            }
        }
    }
}
