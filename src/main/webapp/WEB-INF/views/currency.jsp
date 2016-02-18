<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<c:url var="addAction" value="/currency/add" />

<div>
<form:form action="${addAction}" commandName="currency">
<table>
	<tr>
		<td>
			<form:label path="valuta_name">
				<spring:message text="valutaName"/>
			</form:label>
		</td>
		<td>
			<form:input path="valuta_name" />
		</td>
	</tr>
	<tr>
		<c:if test="${!empty currency.valuta_name}">
			<input type="submit"
				   value="<spring:message text="Edit"/>" />
		</c:if>
		<c:if test="${empty currency.valuta_name}">
			<input type="submit"
				   value="<spring:message text="Add"/>" />
		</c:if>
	</tr>
</table>	
</form:form>

<c:if test="${!empty listCurrency}">
	<br>
	<h3>currency list</h3>
	<table class="data">
	<tr>
		<th width="80">currency ID</th>
		<th width="120">currency Name</th>
		<th width="60">Delete</th>
	</tr>
	<c:forEach items="${listCurrency}" var="currency_item">
		<tr>
			<td>${currency_item.valuta_id}</td>
			<td>${currency_item.valuta_name}</td>
			<td><a href="<c:url value='/currency/edit/${currency_item.valuta_id}' />" ><img src="${editImgUrl}"/></a></td>
			<td><a href="<c:url value='/currency/remove/${currency_item.valuta_id}' />" ><img src="${deleteImgUrl}"/></a></td>
		</tr>
	</c:forEach>
	</table>
</c:if>
</div>