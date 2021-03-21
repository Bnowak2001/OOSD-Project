import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerifier
{
    public static void verifyCustomer(String name,String address, String phoneNumber, String email) throws MyInvalidInputException
    {
        Pattern pat = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher m = pat.matcher(email);
        if(name.isEmpty()||address.isEmpty()||phoneNumber.isEmpty()||email.isEmpty())
        {
            throw new MyInvalidInputException("Some input fields were left unfilled");
        }
        if(!m.matches())
        {
            throw new MyInvalidInputException("Invalid Email Address");
        }
    }
    public static void verifyProduct(String productName,String productDesc,String price) throws MyInvalidInputException
    {
        if(productName.isEmpty()||productDesc.isEmpty()||price.isEmpty())
        {
            throw new MyInvalidInputException("Some input fields were left unfilled");
        }
        Pattern pat = Pattern.compile("[0-9]*.?[0-9]*");
        Matcher m =pat.matcher(price);
        if(!m.matches())
        {
            throw new MyInvalidInputException("Enter Only numbers in price field");
        }
    }
}
