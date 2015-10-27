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
	Add a Vendor
</h1>

<c:url var="addAction" value="/vendor/add" ></c:url>

<form:form action="${addAction}" commandName="vendor">
<table>
	<tr>
		<td>
			<form:label path="vendor_name">
				<spring:message text="VendorName"/>
			</form:label>
		</td>
		<td>
			<form:input path="vendor_name" />
		</td> 
	</tr>
	<tr>
		<c:if test="${!empty vendor.vendor_name}">
			<input type="submit"
				   value="<spring:message text="Edit Vendor"/>" />
		</c:if>
		<c:if test="${empty vendor.vendor_name}">
			<input type="submit"
				   value="<spring:message text="Add Vendor"/>" />
		</c:if>
	</tr>
</table>	
</form:form>

<c:if test="${!empty listVendors}">
	<br>
	<h3>Vendors List</h3>
	<table class="data">
	<tr>
		<th width="80">Vendor ID</th>
		<th width="120">Vendor Name</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listVendors}" var="vendoritem">
		<tr>
			<td>${vendoritem.vendor_id}</td>
			<td>${vendoritem.vendor_name}</td>
			<td><a href="<c:url value='/vendor/remove/${vendoritem.vendor_id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
