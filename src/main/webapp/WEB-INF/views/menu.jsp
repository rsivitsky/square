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
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-th-large"></i> Drop Down
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href="#">Item1</a></li>
                        <li><a href="#">Item2</a></li>
                        <li><a href="#">Item3</a></li>
                    </ul>
                </li>
                <li><a href="/part/list"> ${admin}</a></li>
                <sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_VENDOR')">
                    <li><a href="/offers"> ${offer}</a></li>
                </sec:authorize>
                <li><a href="/order/list">${order}</a></li>
                <li><a href="/vendor">${vendor}</a></li>
                <li class="active"><a href="/about">${about}</a></li>
            </ul>
        </nav>
    </nav>
