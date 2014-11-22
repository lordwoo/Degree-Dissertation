
package misc;

import dao.Database;
import java.sql.SQLException;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;

/**
 * Initialises the {@link Database} class connection parameters by grabbing the
 * appropriate context parameters from the deployment descriptor, and unregisters
 * the database driver when the application closes down.
 * <p>
 * The deployment descriptor must abide by the following naming convention:
 * <ul>
 * <li>database driver class name: "dbClassName"</li>
 * <li>database URL: "dbURL"</li>
 * <li>guest username: "dbUsername"</li>
 * <li>guest password: "dbPassword"</li>
 * </ul>
 */
@WebListener
public class DatabaseInitialiser implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        ServletContext context = event.getServletContext();
        String className = context.getInitParameter("dbClassName");
        String URL = context.getInitParameter("dbURL");
        String username = context.getInitParameter("dbUsername");
        String password = context.getInitParameter("dbPassword");

        try
        {
            Database.init(className, URL, username, password);
        }
        catch (ClassNotFoundException e)
        {
            // TODO: Error logging needed
            throw new RuntimeException(e);
        }
    }

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
        try
        {
            Database.destroy();
        }
        catch (SQLException e)
        {
            // TODO: Error logging needed
        }
    }
}
