import java.sql.*;

/**
 * This class provides methods for deleting records from various
 * tables in the database
 */
public class Delete
{
    /**
     * This method is used for deleting a customer record from the customer table
     * @param id - The id of the customer to be deleted
     */
    public static void customer(int id)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "DELETE FROM Customer WHERE customerId= "+id+";";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement();
            stat.executeUpdate(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used for deleting a product entry from the products table in the database
     * @param id - The id of the product to be deleted
     */
    public static void product(int id)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "DELETE FROM Product WHERE productId= "+id+";";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement();
            stat.executeUpdate(sql);
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
