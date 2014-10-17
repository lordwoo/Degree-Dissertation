
package action;

import framework.Action;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Service to log a user out of the system. Any patient results will be removed
 * from the session.
 */
public class Logout implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        HttpSession session = request.getSession();

        // If user was logged in
        if (session.getAttribute("username") != null)
        {
            session.removeAttribute("username");
            session.removeAttribute("patient");
            request.setAttribute("feedback", "You have been successfully logged out!");
        }
        // If user was not logged in
        else
        {
            request.setAttribute("feedback", "You are already logged out.");
        }

        return "welcome";
    }
}
