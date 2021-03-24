import java.sql.*;

/**
 * This class provides methods for updating existing entries in the database
 */
public class Update
{
    /**
     * This method is used to update an existing customer record
     * @param id - the id of the customer to be updated
     * @param name - the new name of the customer
     * @param address - the new address of the customer
     * @param email - the new email address of the customer
     * @param phonenumber - the new phone number of the customer
     */
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

    /**
     * This method is used to update an existing product entry
     * @param id - the id of the product to be updated
     * @param productName - the new product name
     * @param productDescription - the new product description
     * @param unitPrice - the price of the product
     */
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

    /**
     * This method updates the total invoice price by getting all the invoice items and multiplying their individual price by their quantity
     * and adding it all together
     * @param invoiceId - the id of the invoice to be updated
     */
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
