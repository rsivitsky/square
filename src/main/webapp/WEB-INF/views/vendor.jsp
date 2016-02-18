<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>

<div>
    <c:url var="addAction" value="/vendor/add"></c:url>
    <form:form action="${addAction}" commandName="vendor">
        <table>
            <tr>
                <td>
                    <form:label path="vendor_name">
                        <spring:message text="VendorName"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="vendor_name"/>
                </td>
            </tr>
            <tr>
                <c:if test="${!empty vendor.vendor_name}">
                    <input type="submit"
                           value="<spring:message text="Edit Vendor"/>"/>
                </c:if>
                <c:if test="${empty vendor.vendor_name}">
                    <input type="submit"
                           value="<spring:message text="Add Vendor"/>"/>
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
                    <td><a href="<c:url value='/vendor/edit/${vendoritem.vendor_id}' />"><img src="${editImgUrl}"/></a></td>
                    <td><a href="<c:url value='/vendor/remove/${vendoritem.vendor_id}' />"><img src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>