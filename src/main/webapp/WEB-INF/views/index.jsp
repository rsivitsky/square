<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<c:url var="addPartUrl" value="/part/add"/>
<c:set var="manufacturs" scope="session"/>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <form role="form" name="filter_form" method="get">
                <c:forEach items="${manufacturFilterList}" var="manufacturFilter">
                    <div class="checkbox">
                        <label>
                            <c:if test="${manufacturFilter.usage!=false}">
                                <input type="checkbox" name="manufacturs" checked onclick="this.form.submit();"
                                       value=${manufacturFilter.manufactur.manufactur_id}>
                            </c:if>
                            <c:if test="${manufacturFilter.usage==false}">
                                <input type="checkbox" name="manufacturs" onclick="this.form.submit();"
                                       value=${manufacturFilter.manufactur.manufactur_id}>
                            </c:if>
                                ${manufacturFilter.manufactur.manufactur_name}
                        </label>
                    </div>
                </c:forEach>
                    <%-- <input type="submit" value="Submit">--%>
                 </form>
                 <%--  <%
                      String select[] = request.getParameterValues("manufacturs");
                      if (select != null && select.length != 0) {
                          out.println("You have selected: ");
                          for (int i = 0; i < select.length; i++) {

                              out.println(select[i]);
                          }
                      }
                  %>--%>
        </div>
        <div class="col-md-9">
            <table class="table table-hover table-responsive">
                <%-- <thead style="background:#d3dce3">--%>
                <tr>
                    <th>#</th>
                    <th>Part Name</th>
                    <th colspan="2"></th>
                    <th>Description</th>
                </tr>
                <%-- </thead>
                 <tbody style="background:#ccc">--%>
                <c:forEach items="${listPart}" var="part">
                    <c:url var="editPartUrl" value="/part/edit/${part.part_id}"/>
                    <c:url var="deletePartUrl" value="/part/remove/${part.part_id}"/>
                    <c:url var="editDescUrl" value="/part/descript/edit/${part.part_id}"/>
                    <c:if test="${!empty part.part_name}">
                        <tr>
                            <td><c:out value="${part.part_id}"/></td>
                            <td><c:out value="${part.part_name}"/></td>
                            <td><a href="${editPartUrl}"><img src="${editImgUrl}"/></a></td>
                            <td><a href="${deletePartUrl}"><img src="${deleteImgUrl}"/></a></td>
                            <td><a href="${editDescUrl}">go to description</a></td>
                        </tr>
                    </c:if>
                </c:forEach>
                <%-- </tbody>--%>
            </table>
            <br>
            <sec:authorize access="isAuthenticated()">
                <p>Ваш логин: <sec:authentication property="principal.username"/></p>
            </sec:authorize>
        </div>
    </div>
</div>