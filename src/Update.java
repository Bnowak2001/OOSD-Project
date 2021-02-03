import java.sql.*;

public class Update
{
    public static void Customer(int id,String name,String address,String email, String phonenumber)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "UPDATE CUSTOMER SET name = '"+name+"', address = '"+address+"', email = '"+email+"', phonenumber = '"+phonenumber+"' where customerId = "+id+";";
        System.out.println(sql);
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
