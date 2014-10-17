
package action;

import dao.DataAccessException;
import framework.Action;
import dao.PatientDAO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import form.LoginForm;
import model.Patient;

/**
 * Service for logging a user in to the system. Any existing patient results are
 * removed from the session, and any results that the user already has in the
 * database will be retrieved and added to the session.
 */
public class Login implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        String view;

        LoginForm form = (LoginForm) request.getAttribute("form");
        String username = form.getUsername();

        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // Remove any existing patient from the session
        session.removeAttribute("patient");

        try
        {
            // If patient exists for this user, set patient to session
            Patient patient = PatientDAO.retrieve(username);
            if (patient != null)
            {
                session.setAttribute("patient", patient);
                view = "results";
            }
            else
            {
                view = "welcome";
            }

            request.setAttribute("feedback", "You have been logged in as " + username + "!");
        }
        catch (DataAccessException e)
        {
            // Rollback by logging out the user
            session.removeAttribute("username");
            throw e;
        }

        return view;
    }
}
