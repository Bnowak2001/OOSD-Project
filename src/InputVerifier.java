import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputVerifier
{
    public static String verifyCustomer(String name,String address, String phoneNumber, String email)
    {
        String errors = "";
        Pattern pat = Pattern.compile("^[\\w!#$%&’*+/=?`{|}~^-]+(?:\\.[\\w!#$%&’*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$");
        Matcher m = pat.matcher(email);
        if(!m.matches())
        {
            System.out.println(m.matches());
            errors+= "Incorrectly formatted email. Use this pattern: joebloggs@outlook.ie";
            errors+="\n";
        }

        return errors;
    }
}
