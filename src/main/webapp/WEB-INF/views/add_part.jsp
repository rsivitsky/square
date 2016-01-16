<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
</head>
<body>
<h1>
    Add a Part
</h1>
<c:url var="addAction" value="/part/add"></c:url>
<form:form action="${addAction}" commandName="part" enctype="multipart/form-data">
    <table>
        <tr>
            <td>
                <form:label path="part_name">
                    <spring:message text="PartName"/>
                </form:label>
            </td>
            <td>
                    <form:input path="part_name"/>
            </td>
            <td>
                <input name="img_file" type="file"/>
            </td>

        </tr>
        <tr>
            <td>
                <c:if test="${!empty part.part_name}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>"/>
                </c:if>
                <c:if test="${empty part.part_name}">
                    <input type="submit"
                           value="<spring:message text="Add"/>"/>
                </c:if>
            </td>
        </tr>
    </table>
</form:form>
</body>
</html>
