
package framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Represents an action (a use case) that a user may initiate within the system.
 * <p>
 * Developers can implement this interface to create a concrete action class.
 * The code for the action is placed within the
 * {@link #execute(HttpServletRequest, HttpServletResponse)} method. This method
 * should determine which JSP view is to be selected next, and return a string
 * equal to the name of the JSP, minus the ".jsp", e.g. if "welcome.jsp" is the
 * next view, the method should return "welcome".
 */
public interface Action
{
    /**
     * Executes the action and returns a String representing the next view to be
     * selected.
     *
     * @param request the HTTP request for this action
     * @param response the HTTP response for this action
     * @return the next view to be selected
     * @throws ActionException in any user-defined circumstances
     */
    public String execute(HttpServletRequest request, HttpServletResponse response) throws ActionException;
}
