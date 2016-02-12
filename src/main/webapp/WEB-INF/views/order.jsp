<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.order_date" var="order_date"/>
<spring:message code="label.order_status" var="order_status"/>
<spring:message code="label.order_user" var="order_user"/>
<spring:message code="label.order_part" var="order_part"/>
<spring:message code="label.order_num" var="order_num"/>
<spring:message code="label.order_currency" var="order_currency"/>
<spring:message code="label.order_sum" var="order_sum"/>
<spring:message code="label.order_offer" var="order_offer"/>
<spring:message code="label.edit" var="order_edit"/>
<spring:message code="label.add" var="order_add"/>
<spring:message code="label.delete" var="order_delete"/>

<c:url var="editImgUrl" value="/resources/img/edit.png"/>
<c:url var="deleteImgUrl" value="/resources/img/delete.png"/>
<c:url var="addOrderUrl" value="/order/add"/>

<div class="col-md-12">
    <form:form action="${addOrderUrl}" commandName="order" method="post" enctype="multipart/form-data">
    <table class="table table-hover table-responsive">
        <tr>
            <th>
                <span class="label label-primary">${order_date}</span>
            </th>
            <th>
                <span class="label label-primary">${order_part}</span>
            </th>
            <th>
                <span class="label label-primary">${order_offer}</span>
            </th>
            <th>
                <span class="label label-primary">${order_user}</span>
            </th>
            <th>
                <span class="label label-primary">${order_num}</span>
            </th>
            <th>
                <span class="label label-primary">${order_sum}</span>
            </th>
            <th>
                <span class="label label-primary">${order_status}</span>
            </th>
        </tr>
        <tr>
            <td>
                <form:input type="date" path="order_date" cssStyle="border: none"/>
            </td>
            <td>
                <form:select path="part.part_id" name="part" items="${listPart}" itemValue="part_id"
                             itemLabel="part_name" cssStyle="border: none"/>
            </td>
            <td>
                <form:select path="offer.offer_id" name="offer" items="${listOffers}" itemValue="offer_id"
                             itemLabel="offer_id" cssStyle="border: none"/>
            </td>
            <td>
                <form:select path="user.user_id" name="user" items="${listUser}" itemValue="user_id"
                             cssStyle="border: none"/>
            </td>
            <td>
                <form:input path="order_num" itemLabel="num"/>
            </td>
            <td>
                <form:input path="booking_sum" itemLabel="sum"/>
            </td>
            <td>
                <form:select path="booking_status">
                    <form:option value="-" label="--Please Select"/>
                    <form:options items="${Status}"/>
                </form:select>
            </td>
            <tr>
                <td colspan="7">
                    <c:if test="${!empty order.order_id}">
                        <input type="submit"
                               value="<spring:message text="${order_edit}"/>"/>
                    </c:if>
                    <c:if test="${empty order.order_id}">
                        <input type="submit"
                               value="<spring:message text="${order_add}"/>"/>
                    </c:if>
                </td>
            </tr>
        </tr>
    </table>
    </form:form>

    <c:if test="${!empty orderList}">
    <br>

    <h3>order list</h3>
    <table class="table table-hover table-responsive">
        <tr>
            <th>
                <span class="label label-primary">${order_date}</span>
            </th>
            <th>
                <span class="label label-primary">${order_status}</span>
            </th>
            <th>
                <span class="label label-primary">${order_user}</span>
            </th>
            <th>
                <span class="label label-primary">${order_part}</span>
            </th>
            <th>
                <span class="label label-primary">${order_num}</span>
            </th>
            <th>
                <span class="label label-primary">${order_sum}</span>
            </th>
            <th>
                <span class="label label-primary">${order_currency}</span>
            </th>
            <th>

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
                <td>${order_item.booking_sum}</td>
                <td>${order_item.offer.currency.valuta_name}</td>
                <td><a href="<c:url value='/order/edit/${order_item.order_id}' />" title=${order_edit}><img src="${editImgUrl}"/></a>
                </td>
                <td><a href="<c:url value='/order/remove/${order_item.order_id}' />" title=${order_delete}><img
                        src="${deleteImgUrl}"/></a></td>
            </tr>
        </c:forEach>
    </table>
    </c:if>
    </div>