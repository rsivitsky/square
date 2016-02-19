<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.add" var="add"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.public_cancel" var="cancel"/>
<spring:message code="label.spec_name" var="spec_name"/>
<spring:message code="label.spec_typeofspec" var="spec_typeofspec"/>
<spring:message code="label.spec_measure" var="spec_measure"/>

<spring:url value="/specification/add" var="addAction"/>
<spring:url value="/specification" var="cancelAction"/>
<spring:url value="/resources/img/edit.png" var="editImgUrl"/>
<spring:url value="/resources/img/delete.png" var="deleteImgUrl"/>

<div>
    <form:form action="${addAction}" commandName="specification">
        <table class="table table-hover">
            <tr>
                <th>
                        ${spec_name}
                </th>
                <th>
                        ${spec_typeofspec}
                </th>
                <th>
                        ${spec_measure}
                </th>
            </tr>
            <tr>
                <td>
                    <form:input path="spec_name"/>
                </td>
                <td>
                    <form:select path="typeofspec.tspec_id" items="${listTspec}" itemValue="tspec_id"
                                 itemLabel="tspec_name"/>
                </td>
                <td>
                    <form:select path="measure.measure_id" items="${listMeasure}" itemValue="measure_id"
                                 itemLabel="measure_name"/>
                </td>
            </tr>
            <tr>
                <td colspan="3">
                    <c:if test="${!empty specification.spec_name}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${edit}"/>"/>
                    </c:if>
                    <c:if test="${empty specification.spec_name}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${add}"/>"/>
                    </c:if>
                    <a href="${cancelAction}" class="btn btn-info" role="button">${cancel}</a>
                </td>
            </tr>
        </table>
    </form:form>

    <c:if test="${!empty listSpec}">
        <br>

        <h3>Specification List</h3>
        <table class="table table-hover">
            <c:forEach items="${listSpec}" var="specitem">
                <tr>
                    <td>${specitem.spec_id}</td>
                    <td>${specitem.spec_name}</td>
                    <td>${specitem.typeofspec.tspec_name}</td>
                    <td>${specitem.measure.measure_name}</td>
                    <td><a href="<c:url value='/specification/edit/${specitem.spec_id}' />"><img
                            src="${editImgUrl}"/></a></td>
                    <td><a href="<c:url value='/specification/remove/${specitem.spec_id}' />"><img
                            src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>