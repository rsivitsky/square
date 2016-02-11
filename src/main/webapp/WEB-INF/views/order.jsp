<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<c:url var="addOrderUrl" value="/order/add"/>

<div class="col-md-12">
    <form:form action="${addOrderUrl}" commandName="order" method="post" enctype="multipart/form-data">
        <form:input type="date" path="order_date" cssStyle="border: none"/>

        <form:select path="part.part_id" name="part" items="${listPart}" itemValue="part_id"
                     itemLabel="part_name" cssStyle="border: none"/>

        <form:select path="offer.offer_id" name="offer" items="${listOffers}" itemValue="offer_id"
                     itemLabel="offer_id" cssStyle="border: none"/>

        <form:select path="user.user_id" name="user" items="${listUser}" itemValue="user_id"
                     itemLabel="login" cssStyle="border: none"/>

        <form:input path="order_num" cssStyle="border: none" itemLabel="num"/>

        <form:select path="booking_status">
            <form:option value="-" label="--Please Select"/>
            <form:options items="${Status}"/>
        </form:select>

        <c:if test="${!empty order.order_id}">
            <input type="submit"
                   value="<spring:message text="Edit"/>"/>
        </c:if>
        <c:if test="${empty order.order_id}">
            <input type="submit"
                   value="<spring:message text="Add"/>"/>
        </c:if>
    </form:form>

    <c:if test="${!empty orderList}">
        <br>

        <h3>order list</h3>
        <table class="table table-hover table-responsive">
            <tr>
                <th>
                    date
                </th>
                <th>
                    status
                </th>
                <th>
                    user
                </th>
                <th>
                    part
                </th>
                <th>
                    num
                </th>
                <th>

                </th>

            </tr>
            <c:forEach items="${orderList}" var="order_item">
                <tr>
                    <td><fmt:formatDate pattern="dd-MM-yyyy"
                                        value="${order_item.order_date}"/></td>
                    <td>${order_item.booking_status}</td>
                    <td>${order_item.user.firstname} ${order_item.user.lastname}</td>
                    <td>${order_item.part.part_name}</td>
                    <td>${order_item.order_num}</td>
                    <td><a href="<c:url value='/order/edit/${order_item.order_id}' />"><img src="${editImgUrl}"/></a>
                    </td>
                    <td><a href="<c:url value='/order/remove/${order_item.order_id}' />"><img
                            src="${deleteImgUrl}"/></a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>