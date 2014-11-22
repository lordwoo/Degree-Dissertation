
package misc;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Checks for attempts to access restricted pages without proper authorisation,
 * and redirects the client if such an attempt is made. The following
 * redirections take place:
 * <ul>
 * <li>if user requests login page when already logged in, redirect to welcome,
 * <li>if user requests register page when already logged in, redirect to
 * welcome,
 * <li>if user requests results page when no results available, redirect to
 * login.
 * </ul>
 */
@WebFilter(filterName = "AuthorisationFilter", servletNames = "FrontController")
public class AuthorisationFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig)
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        String view = httpRequest.getPathInfo().substring(1);
        HttpSession session = httpRequest.getSession();

        // If user requests login page when already logged in
        if (view.equals("login") && session.getAttribute("username") != null)
        {
            httpRequest.setAttribute("warning", "You are already logged in. If you "
                    + "wish to login as a different user, please log out first.");

            httpResponse.sendRedirect(httpResponse.encodeRedirectURL("welcome"));
        }
        // If user requests registration page when already logged in
        else if (view.equals("register") && session.getAttribute("username") != null)
        {
            httpRequest.setAttribute("warning", "You are already logged in. If "
                    + "you wish to register as a different user, please log out first.");

            httpResponse.sendRedirect(httpResponse.encodeRedirectURL("welcome"));
        }
        // If user requests results page when there are no results available
        else if (view.equals("results") && session.getAttribute("patient") == null)
        {
            httpRequest.setAttribute("warning", "There are no results available. "
                    + "Please either log in to view any previous results you have "
                    + "received, or complete the questionnaire to obtain new results.");

            httpResponse.sendRedirect(httpResponse.encodeRedirectURL("login"));
        }
        else
        {
            chain.doFilter(request, response);
        }
    }

    @Override
    public void destroy()
    {
    }
}
