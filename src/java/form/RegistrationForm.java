
package form;

import dao.UserDAO;
import framework.Form;
import framework.Validation;
import framework.FormField;

/**
 * A registration form that corresponds to the HTML form in register.jsp.
 */
public final class RegistrationForm extends Form
{
    @FormField(displayName = "Username", minLength = 3, maxLength = 20)
    private String username;

    @FormField(displayName = "Password", minLength = 8, maxLength = 20)
    private String password;

    @FormField(displayName = "Password confirmation", minLength = 8, maxLength = 20)
    private String passwordConf;

    /**
     * Checks that the password and password confirmation are the same.
     */
    @Validation
    public void validatePasswordConf()
    {
        if (passwordConf != null && password != null && !passwordConf.equals(password))
        {
            addErrorMsg("passwordConf", "Password confirmation does not match password.");
        }
    }

    /**
     * Checks that the username doesn't already exist.
     */
    @Validation
    public void userExists()
    {
        if (username != null && UserDAO.exists(username))
        {
            addErrorMsg("username", "Username already exists.");
        }
    }

    /**
     * @return the username
     */
    public String getUsername()
    {
        return username;
    }

    /**
     * @return the password
     */
    public String getPassword()
    {
        return password;
    }

    // passwordConf accessor omitted as it is never needed
}
