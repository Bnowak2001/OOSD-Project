import java.sql.*;
import java.util.Date;

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
