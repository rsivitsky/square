<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="editImgUrl" value="/resources/img/edit.png" />
<c:url var="deleteImgUrl" value="/resources/img/delete.png" />
<spring:url value="/part/add" var="addPartUrl"/>

<div>
  <table class="table table-hover">
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
</table>
<br>

<p><a href="${addPartUrl}">Create new record</a></p>

</div>