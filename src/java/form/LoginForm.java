
package form;

import dao.UserDAO;
import framework.FormField;
import framework.Form;
import framework.Validation;

/**
 * A login form that corresponds to the HTML form in login.jsp.
 */
public final class LoginForm extends Form
{
    @FormField(displayName = "Username", minLength = 3, maxLength = 20)
    private String username;

    @FormField(displayName = "Password", minLength = 8, maxLength = 20)
    private String password;
    
    /**
     * Checks that the specified user exists in the database.
     */
    @Validation
    public void authenticateUser()
    {
        if (username != null && password != null && !UserDAO.authenticate(username, password))
        {
            addErrorMsg("username", "Username or password incorrect.");
        }
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    // password accessor omitted as it is not needed
}
