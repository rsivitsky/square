<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url var="editImgUrl" value="/resources/img/edit.png"/>
<spring:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<spring:url var="addAction" value="/measure/add"/>
<spring:url var="cancelAction" value="/measure"/>

<spring:message code="label.measure_list" var="measure_list"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.delete" var="delete"/>
<spring:message code="label.add" var="add"/>
<spring:message code="label.public_cancel" var="cancel"/>
<spring:message code="label.name" var="name"/>

<div>
    <form:form action="${addAction}" commandName="measure">
        <table class="table table-hover">
            <tr bgcolor="#87ceeb">
                <th>
                        ${name}
                </th>
            </tr>
            <tr>
                <td>
                    <form:input path="measure_name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <c:if test="${!empty measure.measure_name}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${edit}"/>"/>
                    </c:if>
                    <c:if test="${empty measure.measure_name}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${add}"/>"/>
                    </c:if>
                    <a href="${cancelAction}" class="btn btn-info" role="button">${cancel}</a>
                </td>
            </tr>
        </table>
    </form:form>

    <c:if test="${!empty listMeasure}">
        <br>

        <h3>${measure_list}</h3>
        <table class="table table-hover">
            <c:forEach items="${listMeasure}" var="measure_item">
                <tr>
                    <td>${measure_item.measure_id}</td>
                    <td>${measure_item.measure_name}</td>
                    <td><a href="<c:url value='/measure/edit/${measure_item.measure_id}' />" title=${edit}><img
                            src="${editImgUrl}"/></a></td>
                    <td><a href="<c:url value='/measure/remove/${measure_item.measure_id}' />" title=${delete}><img
                            src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
