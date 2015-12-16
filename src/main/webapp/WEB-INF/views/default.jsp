<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
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
<div class="container">
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
</div>
</body>
</html>