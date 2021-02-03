import java.sql.*;

public class Create
//this class contains all the methods for creating new entries in the database
{
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
    public static void invoice(int customerId, String invoiceName)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Insert into invoice values( null, "+customerId+",'"+invoiceName+"' );";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement();
            stat.executeUpdate(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void invoicedProduct(int invoiceId, int productId, int quantity)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Insert into invoicedProduct values("+invoiceId+","+productId+","+quantity+" );";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement();
            stat.executeUpdate(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void product(String productName,String productBrand,double unitPrice)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Insert into product values( null,'"+productName+"','"+productBrand+"',"+unitPrice+");";
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
