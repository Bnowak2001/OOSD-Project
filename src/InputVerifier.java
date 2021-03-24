import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * This class is used to verify input on customer product and invoice entries
 */
public class InputVerifier
{
    /**
     * This method is used to verify inputs on customers it throws an exception if the input is invalid
     * @param name - the name of the customer
     * @param address - the address of the customer
     * @param phoneNumber - the phone number of the customer
     * @param email - the email address of the customer
     * @throws MyInvalidInputException throws invalid input
     */
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

    /**
     * This method is used to verify inputs on products it throws an exception if the input is invalid
     * @param productName - the name of the product
     * @param productDesc - the description of the product
     * @param price- the price of the product
     * @throws MyInvalidInputException throws invalid input
     */
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
