<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.spec_typeofspec" var="spec_typeofspec"/>
<spring:message code="label.add" var="add"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.delete" var="delete"/>
<spring:message code="label.public_cancel" var="cancel"/>
<spring:message code="label.type_specification_list" var="type_specification_list"/>

<spring:url value="/tspec/add" var="addAction"/>
<spring:url value="/tspec" var="cancelAction"/>
<spring:url value="/resources/img/edit.png" var="editImgUrl"/>
<spring:url value="/resources/img/delete.png" var="deleteImgUrl"/>

<div>
    <form:form action="${addAction}" commandName="tspec">
        <table class="table table-hover">
            <tr bgcolor="#87ceeb">
                <th>
                        ${spec_typeofspec}
                </th>
            </tr>
            <tr>
                <td>
                    <form:input path="tspec_name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <c:if test="${!empty tspec.tspec_name}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${edit}"/>"/>
                    </c:if>
                    <c:if test="${empty tspec.tspec_name}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${add}"/>"/>
                    </c:if>
                    <a href="${cancelAction}" class="btn btn-info" role="button">${cancel}</a>
                </td>
            </tr>
        </table>
    </form:form>

    <c:if test="${!empty listtspec}">
        <br>

        <h3>${type_specification_list}</h3>
        <table class="table table-hover">
            <c:forEach items="${listtspec}" var="tspec_item">
                <tr>
                    <td>${tspec_item.tspec_id}</td>
                    <td>${tspec_item.tspec_name}</td>
                    <td><a href="<c:url value='/tspec/edit/${tspec_item.tspec_id}' />" title=${edit}><img
                            src="${editImgUrl}"/></a></td>
                    <td><a href="<c:url value='/tspec/remove/${tspec_item.tspec_id}' />" title=${delete}><img
                            src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>