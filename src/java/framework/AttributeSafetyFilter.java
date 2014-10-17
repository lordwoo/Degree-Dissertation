
package framework;

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

/**
 * Part of the attribute safety component, this filter simply wraps the request
 * and response objects with the attribute safe wrappers.
 *
 * This filter should execute before any others to ensure that the functionality
 * in the wrappers is present for any other code that executes. As such, it
 * should be declared in the deployment descriptor above any other filters.
 */
@WebFilter(filterName = "AttributeSafetyFilter", servletNames = "FrontController")
public class AttributeSafetyFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException
    {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpServletRequest wrappedReq = new AttributeSafeRequestWrapper(httpRequest);
        HttpServletResponse wrappedRes = new AttributeSafeResponseWrapper(httpResponse, httpRequest);

        chain.doFilter(wrappedReq, wrappedRes);
    }

    @Override
    public void destroy()
    {
    }
}
