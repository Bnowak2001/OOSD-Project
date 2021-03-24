
import java.sql.*;

/**
 * This class provides methods for Fetching records from the database
 */
public class Retrive
{
    /**
     * Returns all the records in the customer table
     * @return - Returns all records from the table as a 2d array
     */
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

    /**
     * Returns all the records from the products table
     * @return - Returns all the records as a 2d array
     */
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

    /**
     * Fetches the invoice id and date and the customer name connected to the invoice
     * this is used for a drop down menu in the create invoice panel and view invoice panel
     * @return - All of the records as a 2d array
     */
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

    /**
     * Fetchs all the products under an invoice
     * used in the view invoice panel
     * @param invoiceId - The id of the invoice for which to fetch product list
     * @return - returns a 2d array of all products on an invoice
     */
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

    /**
     * This method returns all the details excluding the list of products on a invoice
     * @param invoiceID the id of invoice to fetch details for
     * @return - a string array of all the details about the invoice
     */
    public static String[] fetchInvoiceForDisplay(int invoiceID)
    {
        Connection con;
        Statement stat;
        ResultSet rs;
        String[] results;
        String sql = "select invoice.InvoiceID , invoice.InvoiceDate , invoice.InvoiceTotal , customer.name , customer.address , customer.email , customer.phonenumber from invoice " +
                "inner join customer on invoice.CustomerID = customer.CustomerID where invoice.InvoiceID = "+invoiceID+" ;";
        try{
            con = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            stat = con.createStatement();
            rs = stat.executeQuery(sql);
            results = new String[rs.getMetaData().getColumnCount()];
            while (rs.next())
            {
                for( int i = 0 ; i < rs.getMetaData().getColumnCount() ; i++ )
                {
                    results[i] = rs.getString(i+1);
                }
            }
        }
        catch (SQLException e)
        {
            e.printStackTrace();
            results = null;
        }
        return results;
    }
    
}
