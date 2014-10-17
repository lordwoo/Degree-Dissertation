
package framework;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * <p>
 * Processes all requests that are sent to the application with the specified
 * URL pattern.
 *
 * <p>
 * If form data has been supplied with the request, the form validation
 * component will be invoked, and if any errors result the user will be sent
 * back to the form. Otherwise, the appropriate service method will be called
 * and the next view determined. If this view is the same as the one originally
 * requested, the request will simply be forwarded to the view, but if a
 * different view is selected, the client will be redirected to the new view,
 * so that their browser URL bar will display the correct URL.
 */
@WebServlet(name = "FrontController", urlPatterns = "/pages/*", loadOnStartup = 1)
public class FrontController extends HttpServlet
{
    private static String viewPath;

    /**
     * Sets the file path prefix for JSP views to the context parameter value
     * declared in the deployment descriptor under the name "viewPath", or to
     * "/WEB-INF/" if no parameter is found.
     *
     * @throws ServletException if a servlet-specific error occurs
     */
    @Override
    public void init()
            throws ServletException
    {
        viewPath = getServletContext().getInitParameter("viewPath");

        // If the context param is not found, set viewPath to an arbitrary value
        if (viewPath == null)
        {
            viewPath = "/WEB-INF/";
        }
    }

    /**
     * @return the view file path prefix
     */
    public static String getViewPath()
    {
        return viewPath;
    }

    /**
     * Processes requests for both HTTP {@code GET} and {@code POST} methods.
     *
     * @param request the request
     * @param response the response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String view = null;
        
        Form form = FormFactory.getForm(request);
        // If a form exists and fails to validate
        if (form != null && !form.validate())
        {
            request.setAttribute("errorMsgs", form.getErrorMsgs());
            view = request.getPathInfo().substring(1);
        }
        else
        {
            if (form != null)
            {
                request.setAttribute("form", form);
            }

            Action action = ActionFactory.getAction(request);
            try
            {
                view = action.execute(request, response);
            }
            catch (ActionException e)
            {
                throw new ServletException(e);
            }
        }

        // If view is the same as originally requested
        if (view.equalsIgnoreCase(request.getPathInfo().substring(1)))
        {
            request.getRequestDispatcher(response.encodeURL(viewPath + view + ".jsp")).forward(request, response);
        }
        else
        {
            response.sendRedirect(response.encodeRedirectURL(view));
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo()
    {
        return "Short description";
    }// </editor-fold>
}
