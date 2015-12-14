<%--
  Created by IntelliJ IDEA.
  User: ruslan
  Date: 12/14/15
  Time: 10:39 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<div id="header" xmlns:jsp="http://java.sun.com/JSP/Page"
     xmlns:spring = "http://www.springframework.org/tags"
     version="2.0">
  <jsp:directive.page contentType="text/html;charset = UTF-8" />
  <jsp:output omit-xml-declaration="yes" />
  <spring:message code="header text" var="headerText"/>
  <di v id = "appname" >
    <hl>${headerText}</hl>
</div>
</div>
</body>
</html>
