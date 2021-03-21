import com.mysql.cj.protocol.Resultset;

import javax.xml.transform.Result;
import java.sql.*;

public class Retrive
{
    public static String[][] fetchCustomers()//gets all data in the customers table and returns it as a 2d array
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];

        int i =0;//index used for getting the row of 2d array
        String sql = "Select * From Customer";
        try {
            //Establishing Connection Preparing Statement And Executing Query
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            //Getting the rows and columns of the result set and using them to initialise a 2D array
            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];

            rs.beforeFirst();//setting the cursor back to default position
            while(rs.next())
            {
                int i2 =0;//index used for getting the column of the 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                }

                i++;
            }
            results=temp;
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return results;
    }
    public static String[][] fetchProducts()
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];
        int i=0;
        String sql = "Select * from Product";
        try {
            con= DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat=con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];
            rs.beforeFirst();

            while(rs.next())
            {
                int i2 =0;//index used for getting the column of the 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                }

                i++;
            }
            results=temp;
        }
        catch (SQLException e)
        {

        }
        return results;
    }
    public static String[][] fetchInvoiceCustomer()
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];
        int i =0;
        String sql = "select invoice.InvoiceID, customer.name, invoice.InvoiceDate from customer inner join invoice on invoice.CustomerID = customer.CustomerID;";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];
            rs.beforeFirst();

            while(rs.next())
            {
                int i2 =0;//index used for getting the column of the 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                }

                i++;
            }
            results=temp;
        }
        catch (SQLException e)
        {

        }
        return results;
    }
    public static String[][] fetchProductList(int invoiceId)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[][] results = new String[0][];
        int i =0;
        String sql = "select Product.ProductName, Product.ProductPrice, invoiceproduct.Quantity from " +
                "Product inner join invoiceproduct on invoiceproduct.ProductID = Product.ProductID where invoiceproduct.InvoiceID = "+invoiceId+";";
        try {
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat = con.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
            rs = stat.executeQuery(sql);

            rs.last();
            String[][] temp = new String[rs.getRow()][rs.getMetaData().getColumnCount()];
            rs.beforeFirst();

            while(rs.next())
            {
                int i2 =0;//index used for getting the column of the 2d array
                while(i2<rs.getMetaData().getColumnCount()){
                    temp[i][i2]=rs.getString(i2+1);
                    i2++;
                }

                i++;
            }
            results=temp;
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        return results;
    }
    
}
