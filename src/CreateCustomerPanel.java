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

        submit.addActionListener(buttonListener);
        clear.addActionListener(buttonListener);

        this.setPreferredSize(new Dimension(600,400));
        this.setBackground(Color.lightGray);
        this.setLayout(new GridBagLayout());
        GridBagConstraints gc = new GridBagConstraints();
        gc.anchor = GridBagConstraints.LINE_END;
        gc.weighty=1;
        gc.weightx=1;
        gc.gridx=0;
        gc.gridy=0;
        add(new JLabel("Customer Name:"),gc);
        gc.gridy=1;
        add(new JLabel("Customer Address"),gc);
        gc.gridy=2;
        add(new JLabel("Customer Phone Number:"),gc);
        gc.gridy=3;
        add(new JLabel("Customer Email:"),gc);
        gc.gridy=4;
        add(submit,gc);

        gc.anchor = GridBagConstraints.LINE_START;
        gc.gridx=1;
        gc.gridy=0;
        add(name,gc);
        gc.gridy=1;
        add(address,gc);
        gc.gridy=2;
        add(phoneNumber,gc);
        gc.gridy=3;
        add(email,gc);
        gc.gridy=4;
        add(clear,gc);

    }
    class ButtonListener implements ActionListener
    {

        @Override
        public void actionPerformed(ActionEvent e) {
            String buttonLabel = e.getActionCommand();

            if(buttonLabel.equals("Submit"))
            {
                Create.customer(name.getText(),address.getText(),email.getText(),phoneNumber.getText());
            }
        }
    }
}
