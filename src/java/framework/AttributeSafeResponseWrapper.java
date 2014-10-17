
package framework;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;
import javax.servlet.http.HttpSession;

/**
 * Part of the attribute safety component, this wrapper adds functionality to
 * the {@code sendRedirect(String)} method. When the method is called, if any
 * request attributes are found, they will be added to a {@code List} called
 * "requestAtts" and stuffed into the session, so that they will survive the
 * loss of the request object when the redirect occurs.
 */
public class AttributeSafeResponseWrapper extends HttpServletResponseWrapper
{
    private HttpServletRequest request;

    public AttributeSafeResponseWrapper(HttpServletResponse response, HttpServletRequest request)
    {
        super(response);
        this.request = request;
    }

    @Override
    public void sendRedirect(String location) throws IOException
    {
        Enumeration<String> requestAttsEnum = request.getAttributeNames();
        if (requestAttsEnum.hasMoreElements())
        {
            ArrayList<String> requestAtts = new ArrayList<>();
            HttpSession session = request.getSession();
            while (requestAttsEnum.hasMoreElements())
            {
                String attribute = requestAttsEnum.nextElement();
                requestAtts.add(attribute);
                session.setAttribute(attribute, request.getAttribute(attribute));
            }

            session.setAttribute("requestAtts", requestAtts);
        }

        super.sendRedirect(location);
    }
}
