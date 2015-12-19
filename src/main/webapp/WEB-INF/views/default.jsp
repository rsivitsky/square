<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%--@ include file="/css/bootstrap.css" --%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN"
"http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="content-type" content="text/html; charset=utf-8"/>
    <link href="<c:url value="/resources/css/bootstrap.css" />" rel="stylesheet"  type="text/css" />
</head>
<body>
<div class="wrapper-container">
    <%--
<table class="table table-hover">

    <tr>
        <td height="20" colspan="2">
            <tiles:insertAttribute name="header" ignore="true"/>
        </td>
    </tr>

    <tr>
        <td width="25%" height="250">
            <tiles:insertAttribute name="menu" ignore="true"/>
        </td>
        <td width="350">
            <tiles:insertAttribute name="body" ignore="true"/>
        </td>
    </tr>
    <tr>
        <td height="20" colspan="2">
            <tiles:insertAttribute name="footer" ignore="true"/>
        </td>
    </tr>
</table>
--%>
        <header>
            <tiles:insertAttribute name="header" ignore="true"/>
            <form name="search" action="#" method="get" class="form-inline form-search pull-right">
                <div class="input-group">
                    <label class="sr-only" for="searchInput">Search</label>
                    <input class="form-control" id="searchInput" type="text" name="search" placeholder="Search">
                    <div class="input-group-btn">
                        <button type="submit" class="btn btn-primary">GO</button>
                    </div>
                </div>
            </form>
        </header>
        <tiles:insertAttribute name="menu" ignore="true"/>
       <%-- <nav>

            <nav class="navbar navbar-default">
                <ul class="nav navbar-nav">
                    <li><a href="/home/">Home</a></li>
                    <li class="active"><a href="/about/">About us</a></li>
                    <li><a href="/services/">Services</a></li>
                    <li><a href="/partners/">Partners</a></li>
                    <li><a href="/customers/">Customers</a></li>
                    <li><a href="/projects/">Projects</a></li>
                    <li><a href="/careers/">Careers</a></li>
                    <li><a href="/contact/">Contact</a></li>
                </ul>
            </nav>
        </nav> --%>
        <div class="heading">

        </div>
        <div class="row">
            <aside class="col-md-7">
                <ul class="list-group submenu">
                    <li class="list-group-item active">Lorem ipsum</li>
                    <li class="list-group-item"><a href="/donec/">Donec tincidunt laoreet</a></li>
                    <li class="list-group-item"><a href="/vestibulum/">Vestibulum elit</a></li>
                    <li class="list-group-item"><a href="/etiam/">Etiam pharetra</a></li>
                    <li class="list-group-item"><a href="/phasellus/">Phasellus placerat</a></li>
                    <li class="list-group-item"><a href="/cras/">Cras et nisi vitae odio</a></li>
                </ul>
            </aside>
            <section class="col-md-17">
                <tiles:insertAttribute name="body" ignore="true"/>
            </section>
        </div>
</div>
<footer>
    <tiles:insertAttribute name="footer" ignore="true"/>
</footer>
</body>
</html>