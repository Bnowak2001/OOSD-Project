import javax.swing.*;
import java.awt.*;

public class MainWindow extends JFrame
{
    public MainWindow()
    {

        this.setTitle("Invoice Manager");
        this.setVisible(true);
        this.setSize(new Dimension(1200,800));
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.add(new MenuPanel());
        this.add(new CustomerPanel());
        this.setLayout(new FlowLayout());
        this.setResizable(false);
    }
}
