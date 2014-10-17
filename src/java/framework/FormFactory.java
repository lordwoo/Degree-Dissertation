
package framework;

import java.util.Map;
import javax.servlet.http.HttpServletRequest;

/**
 * <p>
 * Provides a way to dynamically get a concrete {@link Form} for a given
 * request. The forms Map must be populated prior to use.
 *
 * <p>
 * The correct {@link Form} is determined by an examination of the HTTP method
 * and path info of the request. For example, an HTTP method of "GET" and a path
 * info of "/login" would yield a key of "GET/login", which is then used to
 * query the forms map to obtain the correct {@link Form}.
 */
public class FormFactory
{
    private static Map<String, Class<? extends Form>> forms;
    
    // Declared privately as this class contains only static members
    private FormFactory()
    {
    }

    /**
     * Gets a new instance of a {@link Form}, using the HTTP method and path
     * info to determine the form required.
     * 
     * @param request the HTTP request
     * @return the {@link Form} for this request, or null if there is no form
     */
    public static Form getForm(HttpServletRequest request)
    {
        Form form = null;
        Class<? extends Form> formClass = forms.get(request.getMethod() + request.getPathInfo());
        if (formClass != null)
        {
            try
            {
                form = formClass.newInstance();
                form.setFormData(request.getParameterMap());
            }
            catch (InstantiationException | IllegalAccessException e)
            {
                // This implies a programming error
                throw new RuntimeException("Form instantiation failed for class: " + formClass.getSimpleName(), e);
            }
        }

        return form;
    }

    /**
     * Gets a Map of HTTP method/path info to {@link Form}s.
     *
     * @return the forms Map
     */
    public static Map<String, Class<? extends Form>> getForms()
    {
        return forms;
    }

    /**
     * Sets the Map of HTTP method/path info to {@link Form}s.
     *
     * @param forms a forms Map
     */
    public static void setForms(Map<String, Class<? extends Form>> forms)
    {
        FormFactory.forms = forms;
    }
}
