<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.order_date" var="order_date"/>
<spring:message code="label.order_status" var="order_status"/>
<spring:message code="label.order_part" var="order_part"/>
<spring:message code="label.order_num" var="order_num"/>
<spring:message code="label.order_currency" var="order_currency"/>
<spring:message code="label.order_sum" var="order_sum"/>
<spring:message code="label.cancel" var="order_cancel"/>

<c:url var="cancelImgUrl" value="/resources/img/cancel.png"/>

<div>
  <h3>Cart</h3>
  <table class="table table-hover table-responsive">
    <tr>
      <th>
        <span class="label label-primary">${order_date}</span>
      </th>
      <th>
        <span class="label label-primary">${order_status}</span>
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
    </tr>
    <c:forEach items="${orderListByUser}" var="order_item">
      <tr>
        <td><fmt:formatDate pattern="dd-MM-yyyy"
                            value="${order_item.order_date}"/></td>
        <td>${order_item.booking_status}</td>
        <td>${order_item.part.part_name}</td>
        <td>${order_item.order_num}</td>
        <td>${order_item.booking_sum}</td>
        <td>${order_item.offer.currency.valuta_name}</td>
        <td><a href="<c:url value='/order/cancel/${order_item.order_id}' />" title=${order_cancel}><img src="${cancelImgUrl}"/></a>
        </td>
      </tr>
    </c:forEach>
  </table>
</div>