
package action;

import dao.DataAccessException;
import framework.Action;
import dao.PatientDAO;
import dao.UserDAO;
import form.RegistrationForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.Patient;

/**
 * Service to register a user. If any patient results are available, they will
 * be stored in the database and associated with this user.
 */
public class Register implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        String view;

        RegistrationForm form = (RegistrationForm) request.getAttribute("form");
        String username = form.getUsername();
        String password = form.getPassword();

        UserDAO.create(username, password);
        HttpSession session = request.getSession();
        session.setAttribute("username", username);

        // If user has patient results in session
        Patient patient = (Patient) session.getAttribute("patient");
        if (patient != null)
        {
            try
            {
                PatientDAO.create(patient, username);
                request.setAttribute("feedback", "You have been registered as "
                        + username + "! Your results have been saved. In the future, "
                        + "you can login to view your saved results.");
            }
            catch (DataAccessException e)
            {
                // TODO: Error logging needed
                request.setAttribute("feedback", "You have been registered as "
                        + username + "!");
                request.setAttribute("warning", "Due to a system error, your results "
                        + "could not be saved. Please try again later.");
            }

            view = "results";
        }
        else
        {
            request.setAttribute("feedback", "You have been registered as " + username + "!");
            view = "welcome";
        }

        return view;
    }
}
