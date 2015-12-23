<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
    <spring:message code="label.admin" var="admin"/>
    <spring:message code="label.home" var="home"/>
<spring:message code="label.about" var="about"/>
<spring:message code="label.offer" var="offer"/>
<spring:message code="label.order" var="order"/>
    <nav>
        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li><a href="/index">${home}</a></li>
                <li><a href="/service"> ${admin}</a></li>
                <li><a href="/orders">${order}</a></li>
                <li><a href="/offers">${offer}</a></li>
                <li class="active"><a href="/about">${about}</a></li>
            </ul>
        </nav>
    </nav>
