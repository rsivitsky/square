<%@ page language="java" contentType="text/html; charset=utf8"
		 pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>measure Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a measure
</h1>

<c:url var="addAction" value="/measure/add" ></c:url>

<form:form action="${addAction}" commandName="measure">
<table>
	<tr>
		<td>
			<form:label path="measure_name">
				<spring:message text="measureName"/>
			</form:label>
		</td>
		<td>
			<form:input path="measure_name" />
		</td>
	</tr>
	<tr>
		<c:if test="${!empty measure.measure_name}">
			<input type="submit"
				   value="<spring:message text="Edit"/>" />
		</c:if>
		<c:if test="${empty measure.measure_name}">
			<input type="submit"
				   value="<spring:message text="Add"/>" />
		</c:if>
	</tr>
</table>	
</form:form>

<c:if test="${!empty listMeasure}">
	<br>
	<h3>measure list</h3>
	<table class="data">
	<tr>
		<th width="80">measure ID</th>
		<th width="120">measure Name</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listMeasure}" var="measure_item">
		<tr>
			<td>${measure_item.measure_id}</td>
			<td>${measure_item.measure_name}</td>
			<td><a href="<c:url value='/measure/edit/${measure_item.measure_id}' />" >Edit</a></td>
			<td><a href="<c:url value='/measure/remove/${measure_item.measure_id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
