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
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addAction" value="/part/descript/save"></c:url>
<form:form action="${addAction}" commandName="descriptionWrapper" method="post">
    <table style="border: 1px solid; width: 100%; text-align:center">
        <thead style="background:#d3dce3">
        <tr>
            <th>Descr Name</th>
            <th>Descr Value</th>
            <th>Measure</th>
        </tr>
        </thead>
        <tbody style="background:#ccc">
        <c:forEach items="${descriptionWrapper.descriptionList}" var="descript" varStatus="i">
            <c:url var="deleteDescriptUrl" value="/part/${part.part_id}/descript/remove/${descript.descript_id}" />
            <tr>
                <td><c:out value="${descript.descript_name}"/></td>
                <td>value: <form:input path="descriptionList[${i.index}].descript_value"
                                       value="${descript.descript_value}"/></td>
                <td><c:out value="${descript.specification.measure.measure_name}"/></td>
                <td><a href="${deleteDescriptUrl}"><img src="${deleteImgUrl}"/></a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
    <input type="submit"
           value="<spring:message text="Save"/>"/>
</form:form>
</body>
</html>
