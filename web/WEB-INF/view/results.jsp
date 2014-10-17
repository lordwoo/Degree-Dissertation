<%-- 
    Document   : results
    Created on : 14-Dec-2009, 17:39:52
    Author     : Will
--%>

<%@page import="model.Patient" %>
<%@page import="misc.UnitConverter" %>

<div id="main">
    <c:if test="${not empty feedback}">
        <p class="feedback">${feedback}</p>
    </c:if>
    <c:if test="${not empty warning}">
        <p class="warning">${warning}</p>
    </c:if>
    <h3>Your data</h3>
    <p>Gender: ${patient.gender}</p>
    <p>Age: ${patient.age}</p>
    <p>Weight: ${patient.weight} kg (<% Patient p = (Patient) request.getSession().getAttribute("patient");
                out.print(UnitConverter.kgToLbs(p.getWeight()));%> lbs)</p>
    <h3>Your risk prediction</h3>
        <c:choose>
            <c:when test="${patient.prediction == true}">
            <p>You are considered to be at risk.</p>
            <p>
                This needn't be a cause for alarm - this tool does not provide a diagnosis,
                it only indicates whether or not you fall into an at-risk group. In fact,
                about 60% of people in the at-risk group don't turn out to have osteoporosis.
            </p>
            <h3>Next steps</h3>
            <p>
                We would suggest that you make an appointment to see your doctor to
                discuss your risk of osteoporosis. A doctor will be able to provide
                you with a more thorough assessment, and advise you if you need to take
                any action.
            </p>
            </c:when>
            <c:when test="${patient.prediction == false}">
                <p>
                    You are not considered to be at risk.
                </p>
                <p>
                    This doesn't guarantee that you haven't developed osteoporosis,
                    but less than 10% of the people who are not considered to be at risk
                    turn out to actually have the disease. If you still feel concerned about
                    your risk then you can visit your doctor who will be able to advise you further.
                </p>
                <h3>Next steps</h3>
                <p>
                    We suggest you visit the <a href="<c:url value="/pages/osteoporosis?page=prevention" />">prevention</a>
                    page next, if you haven't already, to learn about how you can
                    reduce your risk of developing osteoporosis later in life.
                </p>
            </c:when>
        </c:choose>
    <c:if test="${empty username}">
        <h3>Save Results</h3>
        <p>
            If you <a href="<c:url value="/pages/register" />">register</a> with us,
            your results will be saved and you can view them at a later date.
        </p>
    </c:if>
</div> <!-- main -->