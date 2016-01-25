<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
    <spring:message code="label.admin" var="admin"/>
    <spring:message code="label.home" var="home"/>
<spring:message code="label.about" var="about"/>
<spring:message code="label.offer" var="offer"/>
<spring:message code="label.order" var="order"/>
<spring:message code="label.vendor" var="vendor"/>
    <nav>
        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li><a href="/index">${home}</a></li>
                <li><a href="/part/list"> ${admin}</a></li>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_VENDOR')">
                    <li><a href="/offers"> ${offer}</a></li>
                </sec:authorize>
                <li><a href="/orders">${order}</a></li>
                <li><a href="/vendor">${vendor}</a></li>
                <li class="active"><a href="/about">${about}</a></li>
            </ul>
        </nav>
    </nav>
