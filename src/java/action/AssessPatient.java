
package action;

import dao.DataAccessException;
import framework.Action;
import dao.PatientDAO;
import form.QuestionnaireForm;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.OSTA;
import model.Patient;

/**
 * Action for assessing a patient's risk of having developed osteoporosis,
 * called when the risk questionnaire is submitted. The results will be set to
 * the session, and if the user is logged in the results will also be added to
 * the database, overriding any that the user already has stored.
 */
public class AssessPatient implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        QuestionnaireForm form = (QuestionnaireForm) request.getAttribute("form");
        Patient patient = new Patient(form.getGender(), form.getAge(), form.getWeight());

        OSTA osta = new OSTA(1);
        patient.setPrediction(osta.predictRisk(patient));

        HttpSession session = request.getSession();
        session.setAttribute("patient", patient);

        String username = (String) session.getAttribute("username");
        try
        {
            // If user is logged in
            if (username != null)
            {
                // If user already has results in database
                if (PatientDAO.retrieve(username) != null)
                {
                    PatientDAO.update(patient, username);
                }
                else
                {
                    PatientDAO.create(patient, username);
                }

                request.setAttribute("feedback", "Your results have been saved. "
                        + "In the future, you can login to view your saved results.");
            }
        }
        catch (DataAccessException e)
        {
            // TODO: Error logging needed
            request.setAttribute("warning", "Due to a system error, your results "
                    + "could not be saved. Please try again later.");
        }

        return "results";
    }
}
