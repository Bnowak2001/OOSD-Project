import java.sql.*;

public class AccountChecker
{

    public static boolean accountMatch(String name, String password)
    {
        //Variable declarations.
        String temp = "";
        Connection connection;
        Statement statement = null;
        ResultSet rs;
        try
        {
            //Establishing a connection to the database.
            connection = DriverManager.getConnection("jdbc:mysql://localhost/project","root","");
            //Statement to get password from the database.
            statement = connection.createStatement();
            rs = statement.executeQuery("Select password from account where username = '"+name+"';");

            //Getting the password as a string from the result set.
            while (rs.next())
            {
                temp = rs.getString("password");
            }

            //Comparing password in the database to user input.
            if(temp.equals(password) && !temp.isEmpty())
            {
                System.out.println("Login Successful");
                return true;//Password matched to username, login process successful.
            }
            return false;//Passwords didn't match account verifier fails.
        }
        catch (SQLException sqlException)
        {
            System.out.println("Sql did a fucky wucky");
            return false;
        }
    }
}
