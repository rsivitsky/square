<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Part's manager</title>
</head>
<body>
<h1>Records</h1>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addPartUrl" value="/part/add" />
<table style="border: 1px solid; width: 100%; text-align:center">
  <thead style="background:#d3dce3">
  <tr>
    <th>Id</th>
    <th>Part Name</th>
    <th colspan="2"></th>
    <th>Description</th>
    <th colspan="3"></th>
  </tr>
  </thead>
  <tbody style="background:#ccc">
  <c:forEach items="${listPart}" var="part">
    <c:url var="editPartUrl" value="/part/edit/${part.part_id}" />
    <c:url var="deletePartUrl" value="/part/remove/${part.part_id}" />
    <c:url var="editDescUrl" value="/part/descript/edit/${part.part_id}" />

    <c:if test="${!empty part.part_name}">
        <tr>
          <td><c:out value="${part.part_id}" /></td>
          <td><c:out value="${part.part_name}" /></td>
          <td><a href="${editPartUrl}"><img src="${editImgUrl}"/></a></td>
          <td><a href="${deletePartUrl}"><img src="${deleteImgUrl}"/></a></td>
          <td><a href="${editDescUrl}">go to description</a></td>
          </tr>
    </c:if>
  </c:forEach>
  </tbody>
</table>
<br>
<br>

<p><a href="${addPartUrl}">Create new record</a></p>

</body>
</html>