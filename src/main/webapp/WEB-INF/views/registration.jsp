<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.user_firstname" var="user_firstname"/>
<spring:message code="label.user_lastname" var="user_lastname"/>
<spring:message code="label.user_login" var="user_login"/>
<spring:message code="label.user_password" var="user_password"/>
<spring:message code="label.user_role" var="user_role"/>
<spring:message code="label.user_vendor" var="user_vendor"/>

<spring:url var="addAction" value="/registration/save"/>
<spring:url value="/registration" var="cancelAction"/>

<div>
    <form:form action="${addAction}" commandName="user">
        <table class="table table-hover">
            <tr bgcolor="#87ceeb">
                <th>
                        ${user_firstname}
                </th>
                <td>
                    <form:input path="firstname"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_lastname}
                </th>
                <td>
                    <form:input path="lastname"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_login}
                </th>
                <td>
                    <form:input path="login"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_password}
                </th>
                <td>
                    <form:input path="password"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_role}
                </th>
                <td>
                    <form:select path="role.role_id">
                        <c:if test="${empty user.firstname}">
                            <form:option value="NONE" label="--- Select ---"/>
                        </c:if>
                        <form:options items="${listRoles}" itemValue="role_id" itemLabel="role_name"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_vendor}
                </th>
                <td>
                    <form:select path="vendor.vendor_id">
                        <c:if test="${empty vendor}">
                            <form:option value="NONE" label="--- Select ---"/>
                        </c:if>
                        <form:options items="${listVendors}" itemValue="vendor_id" itemLabel="vendor_name"/>
                    </form:select>
                </td>
            </tr>
            <tr>
                <td colspan="6">
                    <c:if test="${!empty user.firstname}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${edit}"/>"/>
                    </c:if>
                    <c:if test="${empty user.firstname}">
                        <input type="submit" class="btn btn-info"
                               value="<spring:message text="${add}"/>"/>
                    </c:if>
                    <a href="${cancelAction}" class="btn btn-info" role="button">${cancel}</a>
                </td>
            </tr>
        </table>
    </form:form>
</div>
