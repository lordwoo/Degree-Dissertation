
<div id="main">
    <c:if test="${not empty feedback}">
        <p class="feedback">${feedback}</p>
    </c:if>
    <c:if test="${not empty warning}">
        <p class="warning">${warning}</p>
    </c:if>
    <h2>Osteoporosis Risk Assessment</h2>
    <p>
        Welcome to the Osteoporosis Risk Assessment site!
    </p>
    <p>
        Osteoporosis is a disease that mainly affects the elderly. Sometimes referred
        to as the 'silent epidemic', osteoporosis is extremely difficult to detect,
        and often the first sign that a patient has developed the disease comes when
        they suffer a fracture as the result of a relatively minor bump or fall. The
        World Health Organisation considers osteoporosis to be second only to
        cardiovascular disease as a public health concern.
    </p>
    <p>
        This web site aims to increase awareness of the disease. It provides some
        <a href="<c:url value="/pages/osteoporosis" />">basic information</a> about
        osteoporosis, directions for <a href="<c:url value="/pages/links" />">further information</a>,
        and a <a href="<c:url value="/pages/questionnaire" />">risk assessment tool</a>
        that will help you to assess whether or not you are likely to have developed
        the disease, and advise you on further action to take.
    </p>
</div> <!-- main -->