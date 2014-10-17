
package framework;

/**
 * <p>
 * Exception throws by the
 * {@link Action#execute(HttpServletRequest, HttpServletResponse)} method in
 * user-defined circumstances.
 * 
 * <p>
 * Implements the standard exception constructors.
 */
public class ActionException extends Exception
{
    public ActionException()
    {
        super();
    }

    public ActionException(String message)
    {
        super(message);
    }

    public ActionException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public ActionException(Throwable cause)
    {
        super(cause);
    }
}
