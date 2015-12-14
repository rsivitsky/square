<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE HTML>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>

<html>
<head>
  header
</head>
<body>
<div id="banner">
  <tiles:insertAttribute name="header" />
</div>
<div></div>
<tiles:insertAttribute name="menu" />
<div></div>
<div id="page">
  <tiles:insertAttribute name="body" />
</div>
<div></div>
<div id="footer_wrapper">
  <tiles:insertAttribute name="footer" />
</div>
</body>
</html>