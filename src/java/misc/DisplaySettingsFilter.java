
package misc;

import java.io.IOException;
import javax.servlet.DispatcherType;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

/**
 * Checks for a font size parameter in the request and, if one exists, adds it
 * to the session. The parameter should be called "fontSize" and be a percentage
 * value but without the % symbol, e.g. a parameter of "fontSize=80" would yield
 * a font size of 80%.
 */
@WebFilter(urlPatterns = "*.jsp", dispatcherTypes = {DispatcherType.FORWARD, DispatcherType.ERROR})
public class DisplaySettingsFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig)
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        String fontSize = request.getParameter("fontSize");
        if (fontSize != null)
        {
            HttpServletRequest httpRequest = (HttpServletRequest) request;
            httpRequest.getSession().setAttribute("fontSize", fontSize + "%");
        }

        chain.doFilter(request, response);
    }
    
    @Override
    public void destroy()
    {
    }
}
