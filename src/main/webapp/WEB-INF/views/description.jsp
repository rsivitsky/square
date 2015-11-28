<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>description</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h3 style="border: 1px solid; width: 100%; text-align:center">${part.part_name}</h3>
<c:url var="addAction" value="/part/descript/edit/${part.part_id}"/>
<form:form action="${addAction}" commandName="descriptionList" method="post">
    <table style="border: 1px solid; width: 100%; text-align:center">
        <thead style="background:#d3dce3">
        <tr>
            <th>Descr Name</th>
            <th>Descr Value</th>
            <th>Measure</th>
        </tr>
        </thead>
        <tbody style="background:#ccc">
        <c:forEach items="${descriptionList}" var="descript">
            <tr>
                <td><c:out value="${descript.descript_name}"/></td>
                <td><input value="${descript.descript_value}"/></td>
                <td><c:out value="${descript.specification.measure.measure_name}"/></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="submit"
           value="<spring:message text="Save"/>"/>
</form:form>
</body>
</html>
