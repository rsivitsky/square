<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<style>
    .error {
        color: #ff0000;
    }

    <%--
        .errorblock {
            color: #000;
            background-color: #ffEEEE;
            border: 3px solid #ff0000;
            padding: 8px;
            margin: 16px;
        }--%>
</style>

<spring:message code="label.user_firstname" var="user_firstname"/>
<spring:message code="label.user_lastname" var="user_lastname"/>
<spring:message code="label.user_login" var="user_login"/>
<spring:message code="label.user_password" var="user_password"/>
<spring:message code="label.user_email" var="user_email"/>
<spring:message code="label.user_role" var="user_role"/>
<spring:message code="label.user_vendor" var="user_vendor"/>
<spring:message code="label.edit" var="edit"/>
<spring:message code="label.add" var="add"/>
<spring:message code="label.public_cancel" var="cancel"/>

<spring:url var="addAction" value="/registration/save"/>
<spring:url value="/registration" var="cancelAction"/>

<div>
    <form:form action="${addAction}" commandName="user">
        <%--   <form:errors path="*" cssClass="errorblock" element="div" />--%>
        <table class="table table-hover">
            <tr bgcolor="#87ceeb">
                <td colspan="2">
                    <h3> Please, fill registration fields </h3>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_firstname}
                </th>
                <td>
                    <form:input path="firstname"/>
                    <form:errors path="firstname" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_lastname}
                </th>
                <td>
                    <form:input path="lastname"/>
                    <form:errors path="lastname" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_login}
                </th>
                <td>
                    <form:input path="login"/>
                    <form:errors path="login" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_password}
                </th>
                <td>
                    <form:input path="password"/>
                    <form:errors path="password" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_email}
                </th>
                <td>
                    <form:input path="email"/>
                    <form:errors path="email" cssClass="error"/>
                </td>
            </tr>
            <tr>
                <th>
                        ${user_role}
                </th>
                <td>
                    <form:select path="role.role_id" name="role">
                        <form:option value="NONE" label="--- Select ---"/>
                        <form:options items="${listRolesWithoutAdmin}" itemValue="role_id" itemLabel="role_name"/>
                    </form:select>
                </td>
            </tr>
            <c:if test="${user.role.role_name=='ROLE_VENDOR'}">
                <tr>
                    <th>
                            ${user_vendor}
                    </th>
                    <td>
                        <form:select path="vendor.vendor_id">
                            <form:option value="NONE" label="--- Select ---"/>
                            <form:options items="${listVendors}" itemValue="vendor_id" itemLabel="vendor_name"/>
                        </form:select>
                    </td>
                </tr>
            </c:if>
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
