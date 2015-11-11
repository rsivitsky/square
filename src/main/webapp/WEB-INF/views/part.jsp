<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Part</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<c:url var="addAction" value="/part/add" ></c:url>

<form:form action="${addAction}" commandName="part">
  <table>
    <tr>
      <td>
        <form:label path="part_name">
          <spring:message text="PartName"/>
        </form:label>
      </td>
      <td>
        <form:input path="part_name" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="descriptions">
          <spring:message text="Descriptions"/>
        </form:label>
      </td>
      <td>
        <form:input path="descriptions" />
      </td>
    </tr>
    <tr>
      <td colspan="2">
        <c:if test="${!empty part.part_name}">
          <input type="submit"
                 value="<spring:message text="Edit Part"/>" />
        </c:if>
        <c:if test="${empty part.part_name}">
          <input type="submit"
                 value="<spring:message text="Add Part"/>" />
        </c:if>
      </td>
    </tr>
  </table>
</form:form>

<c:if test="${!empty listPart}">
  <br>
  <h3>Part's list</h3>
  <table class="data">
    <tr>
      <th width="80">Part ID</th>
      <th width="120">Part name</th>
      <th width="120">Description</th>
      <th width="60">Edit</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listPart}" var="partitem">
      <tr>
        <td>${partitem.part_id}</td>
        <td>${partitem.part_name}</td>
        <td>${useritem.description}</td>
        <td><a href="<c:url value='/part/edit/${partitem.part_id}' />" >Edit</a></td>
        <td><a href="<c:url value='/part/remove/${partitem.part_id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>
