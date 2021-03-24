
import java.sql.*;
import java.util.Date;

/**
 * This class is used to create entries in the database.
 * The tables in the database must use auto increment on the id fields
 * It contains several static methods for creating new entries in various tables inside the database
 */
public class Create
//this class contains all the methods for creating new entries in the database
{
    /**
     * This method is used to insert a new entry into the customers table
     * @param name - The String value to be entered into the name column of the customers table
     * @param address - The String value to be entered into the address column of the customers table
     * @param email - The String value to be entered into the email column of the customers table
     * @param phonenumber - The String value to be entered into the phonenumber column of the customers table
     */
    public static void customer(String name,String address,String email, String phonenumber)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Insert into Customer values( null, '"+name+"','"+address+"','"+email+"','"+phonenumber+"' );";
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
     * This method is used to insert a new entry into the invoice table
     * @param customerId - The int value to be entered into the customer id column
     * @param date - The date value to be entered into the invoiceDate column
     */
    public static void invoice(int customerId, Date date)
    {
        Connection con;
        PreparedStatement pstat;
        ResultSet rs;
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());
        String sql = "Insert into invoice values( null,?,?,null );";
        System.out.println(customerId);
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
           pstat = con.prepareStatement(sql);
           pstat.setInt(1,customerId);
           pstat.setDate(2,sqlDate);
           pstat.execute();
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * This method is used to insert a new entry into the invoice product table
     * @param invoiceId - The int value to be inserted into the invoiceId column
     * @param productId - The int value to be inserted into the productId column
     * @param quantity - The int value to be inserted into the quantity column
     */
    public static void invoicedProduct(int invoiceId, int productId, int quantity)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Insert into invoiceproduct values("+invoiceId+","+productId+","+quantity+" );";
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
     * This method is used to insert a new entry into the product table
     * @param productName - The string value to be inserted into the productName column
     * @param productDsc - The string value to be inserted into the productDescription column
     * @param unitPrice - The Double value to be inserted into the price column
     */
    public static void product(String productName,String productDsc,double unitPrice)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Insert into product values( null,'"+productName+"','"+productDsc+"',"+unitPrice+");";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement();
            stat.executeUpdate(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
