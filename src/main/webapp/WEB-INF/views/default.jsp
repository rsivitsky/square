<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>

<!DOCTYPE html>
<html lang="en">

<head>
</head>
<body class = "tundra spring">
<div id="headerWrapper">
  <tiles:insertAttribute name = "header" ignore="true" />
</div>
<div id="wrapper">
  <tiles:insertAttribute name="menu" ignore="true" />
  <div id = "main">
    <tiles:insertAttribute name = "body"/>
    <tiles:insertAttribute name = "footer" ignore = "true"/>
  </div>
</div>
</body>
</html>