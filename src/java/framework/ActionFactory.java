
package framework;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * Provides a way to dynamically get a concrete {@link Action} for a given
 * request. The actions Map must be populated prior to use.
 * <p>
 * The correct {@link Action} is determined by an examination of the HTTP method
 * and path info of the request. For example, an HTTP method of "GET" and a path
 * info of "/login" would yield a key of "GET/login", which is then used to
 * query the actions map to obtain the correct {@link Action}. If no
 * {@link Action} exists for the key, the {@link ViewPage} action is provided
 * instead on the assumption that the request was a simple page view.
 */
public class ActionFactory
{
    private static Map<String, Class<? extends Action>> actions;

    // Declared privately as this class contains only static members
    private ActionFactory()
    {
    }

    /**
     * Gets a new instance of an {@link Action}, using the HTTP method and path
     * info to determine the action required.
     *
     * @param request the request for this action
     * @return the {@link Action} required by this request
     */
    public static Action getAction(HttpServletRequest request)
    {
        Action action = null;
        Class<? extends Action> actionClass = actions.get(request.getMethod() + request.getPathInfo());

        // If no Action exists for this HTTP method/URL path combination
        if (actionClass == null)
        {
            action = new ViewPage();
        }
        else
        {
            try
            {
                action = actionClass.newInstance();
            }
            catch (IllegalAccessException | InstantiationException e)
            {
                // These exceptions indicate a programming error
                throw new RuntimeException("Action instantiation failed for class: "
                        + actionClass.getSimpleName(), e);
            }
        }

        return action;
    }

    /**
     * Gets a Map of HTTP method/path info to {@link Action}s.
     *
     * @return the actions Map
     */
    public static Map<String, Class<? extends Action>> getActions()
    {
        return actions;
    }

    /**
     * Sets the Map of HTTP method/path info to {@link Action}s.
     *
     * @param actions an actions Map
     */
    public static void setActions(Map<String, Class<? extends Action>> actions)
    {
        ActionFactory.actions = actions;
    }
}
