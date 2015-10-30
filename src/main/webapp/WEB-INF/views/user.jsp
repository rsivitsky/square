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
	Add a User
</h1>

<c:url var="addAction" value="/user/add" ></c:url>

<form:form action="${addAction}" commandName="user">
<table>
	<tr>
		<td>
			<form:label path="firstname">
				<spring:message text="FirstName"/>
			</form:label>
		</td>
		<td>
			<form:input path="firstname" />
		</td> 
	</tr>
	<tr>
		<td>
			<form:label path="lastname">
				<spring:message text="LastName"/>
			</form:label>
		</td>
		<td>
			<form:input path="lastname" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="login">
				<spring:message text="Login"/>
			</form:label>
		</td>
		<td>
			<form:input path="login" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="password">
				<spring:message text="Password"/>
			</form:label>
		</td>
		<td>
			<form:input path="password" />
		</td>
	</tr>
	<tr>
		<td>
			<form:label path="role">
				<spring:message text="Role"/>
			</form:label>
		</td>
		<td>
			<form:input path="role" />
		</td>
	</tr>
	<tr>
		<td colspan="2">
			<c:if test="${!empty user.firstname}">
				<input type="submit"
					value="<spring:message text="Edit User"/>" />
			</c:if>
			<c:if test="${empty user.firstname}">
				<input type="submit"
					value="<spring:message text="Add User"/>" />
			</c:if>
		</td>
	</tr>
</table>	
</form:form>

<c:if test="${!empty listUsers}">
	<br>
	<h3>Users List</h3>
	<table class="data">
	<tr>
		<th width="80">User ID</th>
		<th width="120">User Firstname</th>
		<th width="120">User Lastname</th>
		<th width="60">Edit</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listUsers}" var="useritem">
		<tr>
			<td>${useritem.user_id}</td>
			<td>${useritem.firstname}</td>
			<td>${useritem.lastname}</td>
			<td><a href="<c:url value='/edit/${useritem.user_id}' />" >Edit</a></td>
			<td><a href="<c:url value='/remove/${useritem.user_id}' />" >Delete</a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</body>
</html>
