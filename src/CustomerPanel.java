import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CustomerPanel extends JPanel implements ActionListener
{
    CustomerPanel()
    {
        this.setPreferredSize(new Dimension(875,750));
        this.setBackground(Color.lightGray);
    }


    @Override
    public void actionPerformed(ActionEvent e)
    {

    }
}
