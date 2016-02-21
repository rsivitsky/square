<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.add" var="add"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.delete" var="delete"/>
<spring:message code="label.name" var="name"/>
<spring:message code="label.public_cancel" var="cancel"/>

<spring:url var="editImgUrl" value="/resources/img/edit.png"/>
<spring:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<spring:url var="addAction" value="/vendor/add"/>
<spring:url value="/vendor" var="cancelAction"/>

<div class="col-md-3">
    <form:form action="${addAction}" commandName="vendor">
        <div class="row">
            <div class="col-md-12" align="center">
                <form:input path="vendor_name"/>
            </div>
        </div>
        <br>
        <div class="row">
            <div class="col-md-6" align="center">
                <c:if test="${!empty vendor.vendor_name}">
                    <input type="submit" class="btn btn-info"
                           value="<spring:message text="${edit}"/>"/>
                </c:if>
                <c:if test="${empty vendor.vendor_name}">
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
    <c:if test="${!empty listVendors}">
        <table class="table table-hover">
            <c:forEach items="${listVendors}" var="vendoritem">
                <tr>
                    <td>${vendoritem.vendor_id}</td>
                    <td>${vendoritem.vendor_name}</td>
                    <td><a href="<c:url value='/vendor/edit/${vendoritem.vendor_id}' />" title=${edit}><img
                            src="${editImgUrl}"/></a></td>
                    <td><a href="<c:url value='/vendor/remove/${vendoritem.vendor_id}' />" title=${delete}><img
                            src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>