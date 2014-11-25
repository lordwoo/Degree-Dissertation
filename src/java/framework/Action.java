
package framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Represents an action (a service or use case) that a client may initiate
 * within the system.
 * <p>
 * Developers can implement this interface to create a concrete action class.
 * The code for the action is placed within the {@code execute()} method. This
 * method should determine which JSP view is to be selected next, and return a
 * string equal to the name of the JSP, minus the ".jsp", e.g. if "welcome.jsp"
 * is the next view, the method should return "welcome".
 */
public interface Action
{
    /**
     * Executes the action and determines the next view to be selected.
     *
     * @param request the HTTP request for this action
     * @param response the HTTP response for this action
     * @return the name of the next view to be selected
     * @throws ActionException in any user-defined circumstances
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ActionException;
}
