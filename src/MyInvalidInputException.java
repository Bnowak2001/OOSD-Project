/**
 * This is the custom exception for invalid input it gets throw by methods int the input verifier class
 */
public class MyInvalidInputException extends Exception
{
    /**
     * Default constructor
     * @param msg - The error message
     */
    public  MyInvalidInputException(String msg)
    {
        super(msg);
    }
}
