import java.sql.*;

public class Delete
{
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
