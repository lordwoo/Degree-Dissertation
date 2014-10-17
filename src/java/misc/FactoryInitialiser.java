
package misc;

import framework.FormFactory;
import action.*;
import framework.ActionFactory;
import framework.Action;
import framework.Form;
import java.util.HashMap;
import java.util.Map;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import form.*;
import javax.servlet.annotation.WebListener;

/**
 * Initialises the {@link ActionFactory} and {@link FormFactory} maps. Any new
 * actions or forms that are added to the system need a corresponding request
 * mapping entry in the {@link #contextInitialized(ServletContextEvent)} method.
 */
@WebListener
public class FactoryInitialiser implements ServletContextListener
{
    @Override
    public void contextInitialized(ServletContextEvent event)
    {
        Map<String, Class<? extends Action>> actions = new HashMap<>();
        actions.put("POST/register", Register.class);
        actions.put("POST/login", Login.class);
        actions.put("GET/logout", Logout.class);
        actions.put("POST/questionnaire", AssessPatient.class);
        ActionFactory.setActions(actions);

        Map<String, Class<? extends Form>> forms = new HashMap<>();
        forms.put("POST/register", RegistrationForm.class);
        forms.put("POST/login", LoginForm.class);
        forms.put("POST/questionnaire", QuestionnaireForm.class);
        FormFactory.setForms(forms);
    }

    @Override
    public void contextDestroyed(ServletContextEvent event)
    {
    }
}
