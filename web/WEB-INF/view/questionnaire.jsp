
<div id="main">
    <c:choose>
        <c:when test="${not empty username && not empty patient}">
            <p class="warning">
                You are logged in as ${username}. If you submit this questionnaire,
                the results will overwrite your previous results. To complete
                a questionnaire for a different user, please log out first.
            </p>
        </c:when>
        <c:when test="${not empty patient}">
            <p class="warning">
                If you submit this questionnaire, the results will overwrite your
                previous results. To save your results, please register.
            </p>
        </c:when>
    </c:choose>
    <h2>Assess Your Risk</h2>
    <p>
        By filling out the questionnaire below, we can assess your risk of having
        developed osteoporosis and give you your results straight away. All questions
        are required.
    </p>
    <h3>Your security</h3>
    <p>
        The data collected from this questionnaire is anonymous. It does not ask
        you for your name or address, or any other information that could be used
        to easily identify you. We will store the data for future analysis with
        regards to the detection of osteoporosis.
    </p>
    <div id="questionnaire">
        <fieldset>
            <legend>Osteoporosis Risk Questionnaire</legend>
            <form action="<c:url value="/pages/questionnaire" />" method="post">
                <ol>
                    <li>
                        <label class="short">Gender:</label>
                        <input type="radio" id="male" name="gender" value="MALE" <c:if test="${param.gender == 'MALE'}">checked="checked"</c:if> /><label for="male">Male</label>
                        <input type="radio" id="female" name="gender" value="FEMALE" <c:if test="${param.gender == 'FEMALE'}">checked="checked"</c:if> /><label for="female">Female</label>
                        <span class="errorMsg">${errorMsgs.gender}</span>
                    </li>
                    <li class="text">
                        <label class="short" for="age">Age (years):</label>
                        <input type="text" id="age" name="age" value="${param.age}" />
                        <span class="errorMsg">${errorMsgs.age}</span>
                    </li>
                    <li class="text">
                        <label class="short" for="weight">Weight:</label>
                        <input type="text" id="weight" name="weight" value="${param.weight}" />
                        <select name="weightUnit">
                            <option value="pounds" <c:if test="${param.weightUnit == 'pounds'}">selected="selected"</c:if>>pounds</option>
                            <option value="kilograms" <c:if test="${param.weightUnit == 'kilograms'}">selected="selected"</c:if>>kilograms</option>                            
                        </select>
                        (1 stone = 14 pounds)
                        <span class="errorMsg">${errorMsgs.weight}</span>
                    </li>
                </ol>
                <p class="submit">
                    <input type="submit" value="Submit questionnaire" title="Click to get your results" />
                </p>
            </form>
        </fieldset>
    </div> <!-- questionnaire -->
</div> <!-- main -->