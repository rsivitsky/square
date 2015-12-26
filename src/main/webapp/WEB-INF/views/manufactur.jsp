<%@ page language="java" contentType="text/html; charset=utf8"
		 pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>User Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Manufactur
</h1>

<c:url var="addAction" value="/manufactur/add" ></c:url>

<form:form action="${addAction}" commandName="manufactur">
<table>
	<tr>
		<td>
			<form:label path="manufactur_name">
				<spring:message text="ManufacturName"/>
			</form:label>
		</td>
		<td>
			<form:input path="manufactur_name" />
		</td> 
	</tr>
	<tr>
		<c:if test="${!empty manufactur.manufactur_name}">
			<input type="submit"
				   value="<spring:message text="Edit Manufactur"/>" />
		</c:if>
		<c:if test="${empty manufactur.manufactur_name}">
			<input type="submit"
				   value="<spring:message text="Add Manufactur"/>" />
		</c:if>
	</tr>
</table>	
</form:form>

<c:if test="${!empty listManufacturs}">
	<br>
	<h3>Manufacturs List</h3>
	<table class="data">
	<tr>
		<th width="80">Manufactur ID</th>
		<th width="120">Manufactur Name</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listManufacturs}" var="manufacturitem">
		<tr>
			<td>${manufacturitem.manufactur_id}</td>
			<td>${manufacturitem.manufactur_name}</td>
			<td><a href="<c:url value='/manufactur/edit/${manufacturitem.manufactur_id}' />" >Edit</a></td>
			<td><a href="<c:url value='/manufactur/remove/${manufacturitem.manufactur_id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
