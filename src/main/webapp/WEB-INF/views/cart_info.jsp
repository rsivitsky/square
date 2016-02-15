<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:message code="label.cart" var="cart"/>
<spring:message code="label.cart_num" var="cart_num"/>
<spring:message code="label.cart_sum" var="cart_sum"/>
<div class="hero-unit">
<c:set var="cartInfo" value= "${cartInfo}"/>
    <sec:authorize access="isAuthenticated()">
        <c:if test="${!empty cartInfo}">
            <div class="row">
                <div class="col-md-6">
                    <span class="label label-primary">${cart_num}</span>
                </div>
                <div class="col-md-6">
                    <span class="label label-primary">${cart_sum}</span>
                </div>
            </div>
            <div class="row">
                <div class="col-md-6">
                    ${cartInfo[0]}
                </div>
                <div class="col-md-6">
                   ${cartInfo[1]}
                </div>
            </div>
        </c:if>
        <c:if test="${empty cartInfo}">
            <div class="row">
                <div class="col-md-12">
                    empty cart
                </div>
            </div>
        </c:if>
    </sec:authorize>
</div>