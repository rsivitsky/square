<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>

<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<c:url var="addPartUrl" value="/part/add"/>

<div class="container">
    <div class="row">
        <div class="col-md-3">
            <form role="form" name="filter_form" method="get">
                <c:forEach items="${listManufactur}" var="manufactur">
                    <c:if test="${!empty manufactur.manufactur_name}">
                        <div class="checkbox">
                            <label>
                                <input type="checkbox" name="manufacturs" onclick="this.form.submit();" value=${manufactur.manufactur_name}>
                                ${manufactur.manufactur_name}
                            </label>
                        </div>
                    </c:if>
                </c:forEach>
                <div class="checkbox">
                    <label>
                        <input type="checkbox" value="check2" onclick="">
                        Заблокированный чекбокс, не отмечается
                    </label>
                </div>
                <select class="form-control" multiple>
                    <option>1</option>
                    <option>2</option>
                    <option>3</option>
                    <option>4</option>
                    <option>5</option>
                </select>
            </form>
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