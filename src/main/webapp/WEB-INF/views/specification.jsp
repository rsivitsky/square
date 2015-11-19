<%@ page language="java" contentType="text/html; charset=utf8"
		 pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Specification Page</title>
	<style type="text/css">
		.tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
		.tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
		.tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
		.tg .tg-4eph{background-color:#f9f9f9}
	</style>
</head>
<body>
<h1>
	Add a Specification
</h1>

<c:url var="addAction" value="/specification/add" ></c:url>

<form:form action="${addAction}" commandName="specification">
<table>
	<tr>
		<td>
			<form:label path="spec_name">
				<spring:message text="specification name"/>
			</form:label>
		</td>
		<td>
			<form:input path="spec_name" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:select path="typeofspec.tspec_id" items="${listTspec}" itemValue="tspec_id" itemLabel="tspec_name" />
		</td>
	</tr>
	<tr>
		<td>
			<form:select path="measure.measure_id" items="${listMeasure}" itemValue="measure_id" itemLabel="measure_name" />
		</td>
	</tr>
	<tr>
	<td colspan="2">
			<c:if test="${!empty specification.spec_name}">
				<input type="submit"
					value="<spring:message text="Edit"/>" />
			</c:if>
			<c:if test="${empty specification.spec_name}">
				<input type="submit"
					value="<spring:message text="Add"/>" />
			</c:if>
	</td>
	</tr>
</table>	
</form:form>

<c:if test="${!empty listSpec}">
	<br>
	<h3>Specification List</h3>
	<table class="data">
	<tr>
		<th width="80">Spec ID</th>
		<th width="120">Spec name</th>
		<th width="120">Type of spec</th>
		<th width="120">Measure</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listSpec}" var="specitem">
		<tr>
			<td>${specitem.spec_id}</td>
			<td>${specitem.spec_name}</td>
			<td>${specitem.typeofspec.tspec_name}</td>
			<td>${specitem.measure.measure_name}</td>
			<td><a href="<c:url value='/specification/edit/${specitem.spec_id}' />" >Edit</a></td>
			<td><a href="<c:url value='/specification/remove/${specitem.spec_id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
