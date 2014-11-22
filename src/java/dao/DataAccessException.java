
package dao;

/**
 * Unchecked exception to wrap any exceptions that are thrown as a result of
 * failure to access a data source, such as {@code SQLException}, so that:
 * <ul>
 * <li>any checked exceptions will become unchecked and propagate without the
 * need for client handling code,
 * <li>data source implementation will be hidden from clients in higher layers,
 * e.g. the service layer.
 * </ul>
 * <p>
 * Implements the standard exception constructors.
 */
public class DataAccessException extends RuntimeException
{
    public DataAccessException()
    {
        super();
    }

    public DataAccessException(String message)
    {
        super(message);
    }

    public DataAccessException(String message, Throwable cause)
    {
        super(message, cause);
    }

    public DataAccessException(Throwable cause)
    {
        super(cause);
    }
}
