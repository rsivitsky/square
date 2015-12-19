<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<div class="container">
    <spring:message code="label.admin" var="admin"/>
    <nav>
        <nav class="navbar navbar-default">
            <ul class="nav navbar-nav">
                <li><a href="/home/">Home</a></li>
                <li class="active"><a href="/about/">About us</a></li>
                <li><a href="/services/"> ${admin}</a></li>
                <li><a href="/partners/">Partners</a></li>
                <li><a href="/customers/">Customers</a></li>
                <li><a href="/projects/">Projects</a></li>
                <li><a href="/careers/">Careers</a></li>
                <li><a href="/contact/">Contact</a></li>
            </ul>
        </nav>
    </nav>
</div>
