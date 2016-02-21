<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.add" var="add"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.delete" var="delete"/>
<spring:message code="label.name" var="name"/>
<spring:message code="label.public_cancel" var="cancel"/>

<spring:url var="addAction" value="/manufactur/add"/>
<spring:url value="/manufactur" var="cancelAction"/>
<spring:url value="/resources/img/edit.png" var="editImgUrl"/>
<spring:url value="/resources/img/delete.png" var="deleteImgUrl"/>

<div class="col-md-3">
    <form:form action="${addAction}" commandName="manufactur">
        <div class="row">
            <div class="col-md-12" align="center">
                <form:input path="manufactur_name"/>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-6" align="center">
                <c:if test="${!empty manufactur.manufactur_name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="${edit}"/>"/>
                </c:if>
                <c:if test="${empty manufactur.manufactur_name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="${add}"/>"/>
                </c:if>
            </div>
            <div class="col-md-6" align="center">
                <a href="${cancelAction}" class="btn btn-info" role="button">${cancel}</a>
            </div>
        </div>
    </form:form>
</div>

<div class="col-md-9">
    <c:if test="${!empty listManufacturs}">
        <table class="table table-hover">
            <c:forEach items="${listManufacturs}" var="manufacturitem">
                <tr>
                    <td>${manufacturitem.manufactur_id}</td>
                    <td>${manufacturitem.manufactur_name}</td>
                    <td><a href="<c:url value='/manufactur/edit/${manufacturitem.manufactur_id}' />" title=${edit}><img
                            src="${editImgUrl}"/></a></td>
                    <td><a href="<c:url value='/manufactur/remove/${manufacturitem.manufactur_id}' />"
                           title=${delete}><img src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>
