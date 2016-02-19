<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.add" var="add"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.name" var="name"/>
<spring:message code="label.public_cancel" var="cancel"/>
<spring:url value="/role" var="list_role"/>
<spring:url value="/role/add" var="addAction"/>
<spring:url value="/resources/img/edit.png" var="editImgUrl"/>
<spring:url value="/resources/img/delete.png" var="deleteImgUrl"/>

<div class="col-md-3">
	<form:form action="${addAction}" commandName="role" >
			<div class="row">
				<div class="col-md-12" align="center">
					<form:input path="role_name"/>
				</div>
			</div>
			<br>
			<div class="row">
				<div class="col-md-6" align="center">
					<c:if test="${!empty role.role_name}">
						<input type="submit" class="btn btn-info"
							   value="<spring:message text="${edit}"/>"/>
					</c:if>
					<c:if test="${empty role.role_name}">
						<input type="submit" class="btn btn-info"
							   value="<spring:message text="${add}"/>"/>
					</c:if>
				</div>
				<div class="col-md-6" align="center">
					<a href="${list_role}" class="btn btn-info" role="button">${cancel}</a>
				</div>
			</div>
	</form:form>
</div>

<div class="col-md-9">
<c:if test="${!empty listRole}">
	<table class="table table-hover">
	<c:forEach items="${listRole}" var="roleitem">
		<tr>
			<td>${roleitem.role_id}</td>
			<td>${roleitem.role_name}</td>
			<td><a href="<c:url value='/role/edit/${roleitem.role_id}' />" ><img src="${editImgUrl}"/></a></td>
			<td><a href="<c:url value='/role/remove/${roleitem.role_id}' />" ><img src="${deleteImgUrl}"/></a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>
