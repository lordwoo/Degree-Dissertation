
package framework;

import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;
import javax.servlet.http.HttpSession;

/**
 * Part of the attribute safety component, this wrapper adds functionality to
 * the {@code getRequestDispatcher(String)} method. When the method is called,
 * if any request attributes are found in the session in a {@code List}
 * attribute called "requestAtts", they will be stripped out and stuffed back
 * into the request, so that they are available for the view that the request
 * will be forwarded to.
 */
public class AttributeSafeRequestWrapper extends HttpServletRequestWrapper
{
    public AttributeSafeRequestWrapper(HttpServletRequest request)
    {
        super(request);
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path)
    {
        HttpSession session = getSession();
        ArrayList<String> requestAtts = (ArrayList<String>) session.getAttribute("requestAtts");
        if (requestAtts != null)
        {
            for (String attribute : requestAtts)
            {
                setAttribute(attribute, session.getAttribute(attribute));
                session.removeAttribute(attribute);
            }
            session.removeAttribute("requestAtts");
        }

        return super.getRequestDispatcher(path);
    }
}
