import javax.swing.*;
import java.awt.*;

/**
 * This class is used to create the window the program runs in
 */
public class MainWindow extends JFrame
{

    /**
     * The default constructor
     */
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
