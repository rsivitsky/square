<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet" type="text/css"/>
    <script src="/resources/js/jquery-2.1.4.min.js"></script>
    <script src="/resources/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
    <div class="row">
        <div class="col-md-8">
            <tiles:insertAttribute name="menu" ignore="true"/>
        </div>
        <div class="col-md-4">
            <tiles:insertAttribute name="header" ignore="true"/>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-3">
            <tiles:insertAttribute name="filter" ignore="true"/>
            <%--<ul class="list-group">
                <li class="list-group-item active">Lorem ipsum</li>
                <li class="list-group-item"><a href="/donec/">Donec tincidunt laoreet</a></li>
                <li class="list-group-item"><a href="/vestibulum/">Vestibulum elit</a></li>
                <li class="list-group-item"><a href="/etiam/">Etiam pharetra</a></li>
                <li class="list-group-item"><a href="/phasellus/">Phasellus placerat</a></li>
                <li class="list-group-item"><a href="/cras/">Cras et nisi vitae odio</a></li>
            </ul>--%>
        </div>
        <div class="col-sm-9">
            <tiles:insertAttribute name="body" ignore="true"/>
        </div>
    </div>
    <div class="row">
        <div class="col-sm-10" align="center">
            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username"/></p>
            </sec:authorize>
            <tiles:insertAttribute name="footer" ignore="true"/>
        </div>
    </div>
</div>
</body>

</html>