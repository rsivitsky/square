<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <title>Insert title here</title>
</head>
<body>
<h1>Records</h1>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<c:url var="addUrl" value="/part/add" />
<table style="border: 1px solid; width: 100%; text-align:center">
  <thead style="background:#d3dce3">
  <tr>
    <th>Id</th>
    <th>Part Name</th>
    <th colspan="2"></th>
    <th>Descr Name</th>
    <th>Descr Value</th>
    <th colspan="3"></th>
  </tr>
  </thead>
  <tbody style="background:#ccc">
  <c:forEach items="${listPart}" var="part">
    <c:url var="editUrl" value="/part/edit?pid=${part.part_id}" />
    <c:url var="deleteUrl" value="/part/remove?pid=${part.part_id}" />

    <c:if test="${!empty part.part_name}">
      <c:forEach items="${part.descriptions}" var="descript">
        <tr>
          <td><c:out value="${part.part_id}" /></td>
          <td><c:out value="${part.part_name}" /></td>
          <td><a href="${editUrl}"><img src="${editImgUrl}"/></a></td>
          <td><a href="${deleteUrl}"><img src="${deleteImgUrl}"/></a></td>

          <td><c:out value="${descript.descript_name}" /></td>
          <td><c:out value="${descript.descript_value}" /></td>
          <c:url var="addCcUrl" value="/part/descript/add?pid=${part.part_id}" />
          <c:url var="editCcUrl" value="/part/descript/edit?pid=${part.part_id}&descr_id=${descript.descript_id}" />
          <c:url var="deleteCcUrl" value="/part/descript/delete?descr_id=${descript.descript_id}" />
          <td><a href="${addCcUrl}">+</a></td>
          <td><a href="${editCcUrl}"><img src="${editImgUrl}"/></a></td>
          <td><a href="${deleteCcUrl}"><img src="${deleteImgUrl}"/></a></td>
        </tr>
      </c:forEach>
    </c:if>

    <c:if test="${empty part.descriptions}">
      <tr>
        <td><c:out value="${part.part_id}" /></td>
        <td><c:out value="${part.part_name}" /></td>
        <td><a href="${editUrl}"><img src="${editImgUrl}"/></a></td>
        <td><a href="${deleteUrl}"><img src="${deleteImgUrl}"/></a></td>

        <td>N/A</td>
        <td>N/A</td>
        <c:url var="addCcUrl" value="/part/descript/add?pid=${part.part_id}" />
        <td><a href="${addCcUrl}">+</a></td>
        <td></td>
        <td></td>
      </tr>
    </c:if>

  </c:forEach>
  </tbody>
</table>

<c:if test="${empty part}">
  No records found.
</c:if>

<p><a href="${addUrl}">Create new record</a></p>

</body>
</html>