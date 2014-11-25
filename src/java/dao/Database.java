
package dao;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * A utility class for connecting to a database. The connection parameters
 * should be injected via the {@code init()} method prior to use.
 */
public class Database
{
    private static String URL;
    private static String username;
    private static String password;

    // Declared privately as this class contains only static members
    private Database()
    {
    }

    /**
     * Initialises the database connection parameters and loads the database
     * driver class.
     *
     * @param className the name of the JDBC driver class
     * @param URL the URL of the database
     * @param username the username for guest connections
     * @param password the password for guest connections
     * @throws ClassNotFoundException if the JDBC driver cannot be found
     */
    public static void init(String className, String URL, String username, String password)
            throws ClassNotFoundException
    {
        Database.URL = URL;
        Database.username = username;
        Database.password = password;
        Class.forName(className);
    }

    /**
     * A convenience method to connect to the database specified by the
     * connection parameters.
     *
     * @return a connection to the database
     * @throws SQLException if a database access error occurs
     */
    public static Connection connect() throws SQLException
    {
        return DriverManager.getConnection(URL, username, password);
    }

    /**
     * Deregisters the database driver. This is usually unnecessary, as most
     * containers will do this automatically, but it has been included for
     * completeness.
     *
     * @throws SQLException if a database access error occurs
     */
    public static void destroy() throws SQLException
    {
        Driver driver = DriverManager.getDriver(URL);
        DriverManager.deregisterDriver(driver);
    }

    /**
     * @return the URL of the database
     */
    public static String getURL()
    {
        return URL;
    }

    /**
     * @return the username for guest connections
     */
    public static String getUsername()
    {
        return username;
    }

    /**
     * @return the password for guest connections
     */
    public static String getPassword()
    {
        return password;
    }
}
