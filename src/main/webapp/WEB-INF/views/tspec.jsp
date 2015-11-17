<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>Type of specification page</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<h1>
  Add a Role
</h1>

<c:url var="addAction" value="/tspec/add" ></c:url>

<form:form action="${addAction}" commandName="tspec">
  <table>
    <tr>
      <td>
        <form:label path="tspec_name">
          <spring:message text="TSpec_Name"/>
        </form:label>
      </td>
      <td>
        <form:input path="tspec_name" />
      </td>
    </tr>
    <tr>
      <c:if test="${!empty tspec.tspec_name}">
        <input type="submit"
               value="<spring:message text="Edit Type of specification/>" />
      </c:if>
      <c:if test="${empty tspec.tspec_name}">
       <input type="submit"
        value="<spring:message text="Edit Type of specification/>" />
      </c:if>
    </tr>
  </table>
</form:form>

<c:if test="${!empty listtspec}">
  <br>
  <h3>TSpec List</h3>
  <table class="data">
    <tr>
      <th width="80">TSpec ID</th>
      <th width="120">TSpec Name</th>
      <th width="60">Delete</th>
    </tr>
    <c:forEach items="${listtspec}" var="tspec_item">
      <tr>
        <td>${tspec_item.tspec_id}</td>
        <td>${tspec_item.tspec_name}</td>
        <td><a href="<c:url value='/tspec/edit/${tspec_item.tspec_id}' />" >Edit</a></td>
        <td><a href="<c:url value='/tspec/remove/${tspec_item.tspec_id}' />" >Delete</a></td>
      </tr>
    </c:forEach>
  </table>
</c:if>
</body>
</html>