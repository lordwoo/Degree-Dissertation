
package framework;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * The default {@link Action}, used when no action matching the request's
 * parameters is found in the {@link ActionFactory}'s actions map. This action
 * simply returns the name of the view originally requested.
 */
public class ViewPage implements Action
{
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response)
    {
        return request.getPathInfo().substring(1);
    }
}
