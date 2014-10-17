
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * A utility class for manipulating user records in the database.
 */
public class UserDAO
{
    // Declared privately as this class contains only static members
    private UserDAO()
    {
    }

    /**
     * Creates a user in the database.
     * 
     * @param username the username for the user
     * @param password the password for the user
     * @return the number of rows affected by the insert, 1 if the operation was
     * successful, 0 otherwise
     * @throws DataAccessException if a data access error occurs
     */
    public static int create(String username, String password)
            throws DataAccessException
    {
        String sqlInsert = "INSERT INTO \"user\" VALUES (?, ?);";
        int rowCount;
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlInsert))
        {
            statement.setString(1, username);
            statement.setString(2, password);
            rowCount = statement.executeUpdate();
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return rowCount;
    }

    /**
     * Checks if a username already exists in the database.
     * 
     * @param username the username to check
     * @return true if the user exists, false otherwise
     * @throws DataAccessException if a data access error occurs
     */
    public static boolean exists(String username)
            throws DataAccessException
    {
        String sqlQuery = "SELECT * FROM \"user\" WHERE username = ?;";
        boolean exists;
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlQuery))
        {
            statement.setString(1, username);
            exists = statement.executeQuery().next();
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return exists;
    }

    /**
     * Authenticates a username and password combination.
     *
     * @param username the username to be authenticated
     * @param password the password to be authenticated
     * @return true if the username exists with the supplied password, false if
     * the username exists with a different password or the username does not
     * exist
     * @throws DataAccessException if a data access error occurs
     */
    public static boolean authenticate(String username, String password)
            throws DataAccessException
    {
        boolean authentic = false;
        String sqlQuery = "SELECT \"password\" FROM \"user\" WHERE username = ?;";
        try (Connection conn = Database.connect();
             PreparedStatement statement = conn.prepareStatement(sqlQuery))
        {
            statement.setString(1, username);
            try (ResultSet rs = statement.executeQuery())
            {
                if (rs.next())
                {
                    authentic = rs.getString("password").equals(password);
                }
            }
        }
        catch (SQLException e)
        {
            throw new DataAccessException(e);
        }

        return authentic;
    }
}
