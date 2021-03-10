import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{

    public MainWindow()
    {

        this.setTitle("Invoice Manager");
        this.setVisible(true);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLayout(new FlowLayout());
        this.add(new MenuPanel());
        this.add(new CreateCustomerPanel());
        this.setResizable(false);
        this.pack();
    }
}
