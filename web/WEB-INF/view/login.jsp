<%-- 
    Document   : login
    Created on : 24-Apr-2011, 14:20:32
    Author     : Will
--%>

<div id="main">
    <c:if test="${not empty warning}">
        <p class="warning">${warning}</p>
    </c:if>
        <h2>Login</h2>
    <div id="questionnaire">
        <fieldset>
            <legend>Log in</legend>
            <form action="<c:url value="/pages/login" />" method="post">
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
                </ol>
                <p class="submit">
                    <input type="submit" value="Log in" title="Click to log in" />
                </p>
            </form>
        </fieldset>
    </div> <!-- questionnaire -->
    <h3>Not registered?</h3>
    <p>Click to <a href="<c:url value="/pages/register" />">register</a></p>
</div> <!-- main -->