<%-- 
    Document   : osteoporosis
    Created on : 29-Oct-2009, 14:15:44
    Author     : WillAtterson
--%>
<div id="sidebarleft">
    <ul>
        <li <c:if test="${param.page == 'what' || empty param.page}">class="current"</c:if>><a href="<c:url value="?page=what" />">What is Osteoporosis?</a></li>
        <li <c:if test="${param.page == 'effect'}">class="current"</c:if>><a href="<c:url value="?page=effect" />">What are it's effects?</a></li>
        <li <c:if test="${param.page == 'who'}">class="current"</c:if>><a href="<c:url value="?page=who" />">Who does it affect?</a></li>
        <li <c:if test="${param.page == 'diagnosis'}">class="current"</c:if>><a href="<c:url value="?page=diagnosis" />">How is it diagnosed?</a></li>
        <li <c:if test="${param.page == 'treatment'}">class="current"</c:if>><a href="<c:url value="?page=treatment" />">How is it treated?</a></li>
        <li <c:if test="${param.page == 'prevention'}">class="current"</c:if>><a href="<c:url value="?page=prevention" />">How is it prevented?</a></li>
        <li <c:if test="${param.page == 'risk'}">class="current"</c:if>><a href="<c:url value="?page=risk" />">Am I at risk?</a></li>
    </ul>
</div>
<div id="sidebarright">
    <c:choose>
        <c:when test="${param.page == 'who'}">
            <em>
                <q>
                    One in two women and one in five men over the age of 50 will
                    suffer a fracture in their lifetime, mainly as a result of osteoporosis.
                </q>
            </em>
        </c:when>
    </c:choose>
</div>
<div id="main" style="margin: 0 200px;"> <!-- Overwriting "margin" css to fit left sidebar -->
    <h2>About Osteoporosis</h2>
    <c:choose>
        <c:when test="${param.page == 'what' || empty param.page}">
            <h3>What is osteoporosis?</h3>
            <p>
                Bones are made up of a thick outer shell and a strong, inner honeycomb-like
                mesh of tiny struts. As a bone begins to wear out, it is broken down and
                replaced. In children, the replacement happens very rapidly to enable the
                skeleton to increase in size. However, as you get older, this process slows
                down, and after about 35 you will begin to experience a gradual loss of bone
                density, as the inner mesh begins to wear thin.
            </p>
            <p>
                If bone density falls below a certain point, a person is considered to have
                osteoporosis, which literally means 'porous bone'. Osteoporosis very rarely
                occurs before the age of 45.
            </p>
        </c:when>
        <c:when test="${param.page == 'effect'}">
            <h3>What are it's effects?</h3>
            <p>
                Osteoporosis itself doesn't cause any difficulties. Rather, a person
                suffering from osteoporosis has a greater chance of suffering a bone fracture
                (a broken bone) as a result of a minor bump or fall, where a healthy person
                would suffer no ill effects.
            </p>

            <p>
                Bone fractures can occur anywhere, but the most common fractures are to the
                hip, spine, or wrists. Hip fractures are particularly problematic, and often
                result in decreased mobility and, in some cases, increased mortality. Spinal
                fractures can result in a bending of the back or loss of height. Wrist fractures
                tend to be less serious, and often occur when a person puts out their arm to
                break a fall.
            </p>
        </c:when>
        <c:when test="${param.page == 'who'}">
            <h3>Who does it affect?</h3>
            <p>
                Osteoporosis mainly affects the elderly, as bones lose density as a natural
                part of the ageing process. However, women are more likely to develop
                osteoporosis than men, as they tend to have smaller bones, and the onset of
                menopause causes the loss of bone to accelerate for several years. A study in
                the UK showed that one in two women and one in five men over the age of 50 will
                suffer a fracture in their lifetime, mainly as a result of osteoporosis.
            </p>
            <p>
                There are a number of other factors that increase the risk of developing
                osteoporosis. These include race, low body weight, smoking, and drinking
                heavily.
            </p>
        </c:when>
        <c:when test="${param.page == 'diagnosis'}">
            <h3>How is it diagnosed?</h3>
            <p>
                If you believe you may have developed osteoporosis, the next step to take is
                to visit your doctor. If your doctor agrees that you are at risk, you may be
                sent to have a bone density scan. A bone density scanner uses x-rays to measure
                your bone density. The process is painless and unintrusive, and usually take
                about 10 - 15 minutes.
            </p>
        </c:when>
        <c:when test="${param.page == 'treatment'}">
            <h3>How is it treated?</h3>
            <p>
                If you've been diagnosed with osteoporosis, a number of drug treatments are
                available to help reduce the risk of bone fracture. Some of these work to
                reduce the rate that bones are broken down, whilst others work to stimulate
                the cells that build new bone. As a result, some people will experience an
                increase in bone density.
            </p>

            <p>
                Generally, drug treatments seem to reduce the risk of fracture by about 50%.
                Changes in lifestyle and situation can also help to reduce the risk of
                fracture, for example taking your time climbing stairs, having your eyesight
                and hearing checked regularly, and securing any loose rugs or carpets in the
                house. Taking up activities that improve balance can also help, such as
                dancing or Tai Chi.
            </p>
        </c:when>
        <c:when test="${param.page == 'prevention'}">
            <h3>How is it prevented?</h3>
            <p>
                The best opportunity for preventing osteoporosis is during early life
                (childhood, adolescence, and early adulthood). By taking plenty of weight
                bearing exercise and eating a healthy, calcium-rich diet, bone strength can be
                maximised. Reducing alcohol intake and quitting smoking can also help reduce
                your risk of developing osteoporosis.
            </p>
        </c:when>
        <c:when test="${param.page == 'risk'}">
            <h3>Am I at risk?</h3>
            <p>
                The only way to reliably determine if you have developed osteoporosis is if
                your doctor recommends you for a bone density scan. If you're concerned that you
                may be at risk, make an appointment with your doctor.
            </p>

            <p>
                However, a number of risk assessment questionnaires have been developed to
                help doctors determine who is at risk and should therefore be sent for bone
                density scanning. These questionnaires are not 100% accurate, but can give a
                good indication of the likelihood of a person having developed the disease.
                This web site provides a questionnaire for your use, and on completion it will
                tell you if you fall into a high risk category.
            </p>

            <p><a href="<c:url value="/pages/questionnaire" />">Assess your risk</a></p>
            <p><a href="<c:url value="/pages/links" />">Find out more about osteoporosis</a></p>

            <!-- Add something about this information being correct at the time of writing. Some things,
            like the 50% drug effectiveness stat, may change over time. -->

        </c:when>
        <c:otherwise>
            <p>
                Unfortunately, the page you were looking for cannot be found.
            </p>
            <p>
                Please use the buttons above or the links to the left to navigate
                to the page you're looking for.
            </p>
        </c:otherwise>
    </c:choose>
</div> <!-- main -->
