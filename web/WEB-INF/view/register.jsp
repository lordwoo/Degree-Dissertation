
<div id="main">
    <h2>Register</h2>
    <p>
        Register by choosing a username and password.
    </p>
    <p>
        Usernames must be between 3 and 20 characters.<br />
        Passwords must be between 8 and 20 characters.<br />
    </p>
    <div id="questionnaire">
        <fieldset>
            <legend>Register</legend>
            <form action="<c:url value="/pages/register" />" method="post">
                <ol>
                    <li>
                        <label class="short" for="username">Username: </label>
                        <input type="text" id="username" name="username" maxlength="20" value="${param.username}" />
                        <span class="errorMsg">${errorMsgs.username}</span>
                    </li>
                    <li>
                        <label class="short" for="password">Password: </label>
                        <input type="password" id="password" name="password" maxlength="20" />
                        <span class="errorMsg">${errorMsgs.password}</span>
                    </li>
                    <li>
                        <label class="short" for="passwordConf">Confirm password: </label>
                        <input type="password" id="passwordConf" name="passwordConf" maxlength="20" />
                        <span class="errorMsg">${errorMsgs.passwordConf}</span>
                    </li>
                </ol>
                <p class="submit">
                    <input type="submit" value="Register" title="Click to register" />
                </p>
            </form>
        </fieldset>
    </div> <!-- questionnaire -->
</div> <!-- main -->