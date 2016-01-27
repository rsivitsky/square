<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<nav class="navbar navbar-default navbar-fixed-bottom" role="navigation">
<div class="container" align="center">
    <spring:message code="label.contact" var="contact" />
    ${contact}
</div>
</nav>