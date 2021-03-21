import java.sql.*;

public class Update
{
    public static void Customer(int id,String name,String address,String email, String phonenumber)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "UPDATE CUSTOMER SET name = '"+name+"', address = '"+address+"', email = '"+email+"', phonenumber = '"+phonenumber+"' where customerId = "+id+";";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement();
            stat.executeUpdate(sql);

        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
    public static void Product(int id, String productName, String productDescription , double unitPrice)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String sql = "Update Product set productName = '"+productName+"', productDescription = '"+productDescription+"', ProductPrice = '"+unitPrice+"' where productID = "+id+";";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat = con.createStatement();
            stat.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
    }
    public static void updateInvoiceValue(int invoiceId)
    {
        String[][] invoicedItems = Retrive.fetchProductList(invoiceId);
        Connection con;
        Statement stat;
        double sum = 0;
        for(int i = 0 ; i < invoicedItems.length ; i++)
        {
            double quantity = Double.parseDouble(invoicedItems[i][2]);
            double price = Double.parseDouble(invoicedItems[i][1]);
            sum += quantity*price;
        }
        String sql = "Update Invoice set InvoiceTotal = "+sum+" where InvoiceID = "+invoiceId;
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat = con.createStatement();
            stat.executeUpdate(sql);
        }
        catch (SQLException e){
            e.printStackTrace();
        }

    }
}
