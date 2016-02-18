<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<spring:message code="label.admin" var="admin"/>
<spring:message code="label.home" var="home"/>
<spring:message code="label.about" var="about"/>
<spring:message code="label.offer" var="offer"/>
<spring:message code="label.order" var="order"/>
<spring:message code="label.vendor" var="vendor"/>
<spring:message code="label.role" var="role"/>
<spring:message code="label.measure" var="measure"/>
<spring:message code="label.currency" var="currency"/>
<spring:message code="label.manufactur" var="manufactur"/>
<spring:message code="label.part" var="part"/>
<spring:message code="label.user" var="user"/>
<spring:message code="label.specification" var="specification"/>
<spring:message code="label.typeOfSpec" var="typeOfSpec"/>

<spring:message code="label.description" var="description"/>

<spring:message code="label.contact_info" var="contact_info"/>

<c:url var="roleUrl" value="/role"/>
<c:url var="partUrl" value="/part/list"/>
<c:url var="userUrl" value="/user"/>
<c:url var="currencyUrl" value="/currency"/>
<c:url var="manufacturUrl" value="/manufactur"/>
<c:url var="vendorUrl" value="/vendor"/>
<c:url var="measureUrl" value="/measure"/>
<c:url var="specificationUrl" value="/specification"/>
<c:url var="typeOfSpecUrl" value="/tspec"/>
<c:url var="homeUrl" value="/index"/>
<c:url var="offerUrl" value="/offers"/>
<c:url var="orderUrl" value="/order/list"/>
<c:url var="aboutUrl" value="#"/>

<nav>
    <nav class="navbar navbar-default">
        <ul class="nav navbar-nav">
            <li><a href="${homeUrl}">${home}</a></li>
            <sec:authorize access="hasAnyRole('ROLE_ADMIN')">
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                        <i class="icon-th-large"></i> ${admin}
                        <b class="caret"></b>
                    </a>
                    <ul class="dropdown-menu">
                        <li><a href=${offerUrl}>${offer}</a></li>
                        <li><a href=${orderUrl}>${order}</a></li>
                        <li><a href=${roleUrl}>${role}</a></li>
                        <li><a href=${userUrl}>${user}</a></li>
                        <li><a href=${partUrl}>${part}</a></li>
                        <li><a href=${measureUrl}>${measure}</a></li>
                        <li><a href=${typeOfSpecUrl}>${typeOfSpec}</a></li>
                        <li><a href=${specificationUrl}>${specification}</a></li>
                        <li><a href=${currencyUrl}>${currency}</a></li>
                        <li><a href=${manufacturUrl}>${manufactur}</a></li>
                        <li><a href=${vendorUrl}>${vendor}</a></li>
                    </ul>
                </li>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_VENDOR')">
                <li><a href="${offerUrl}"> ${offer}</a></li>
            </sec:authorize>
            <sec:authorize access="hasAnyRole('ROLE_VENDOR')">
                <li><a href="${orderUrl}">${order}</a></li>
            </sec:authorize>
            <li class="active"><a href="${aboutUrl}">${about}</a></li>
        </ul>
    </nav>
</nav>
