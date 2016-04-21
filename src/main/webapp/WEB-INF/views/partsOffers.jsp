<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<spring:url value="/part/photo" var="partPhotoUrl"/>
<spring:url value="/part/description/${part[2]}" var="partInfo"/>
<spring:message code="label.vendors" var="number_sellers"/>
<spring:message code="label.put_to_cart" var="put_to_cart"/>
<spring:message code="label.price_range" var="price_range"/>

<c:set var="quantity" scope="request"/>

<div class="col-md-12">
    <c:if test="${part != null}">
        <div class="row">
            <div class="col-md-4">
                <a href="${partInfo}"><img src="${partPhotoUrl}/${part[0]}" class="img-rounded" height="40"
                                           width="150"/></a>
            </div>
            <div class="col-md-4">
                <label class="control-label">${part[1]}</label>
            </div>
            <div class="col-md-4">
                <label class="control-label">${price_range}: ${part[2]} - ${part[3]}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label class="control-label">${number_sellers}: ${part[4]}</label>
            </div>
        </div>
    </c:if>
    <c:if test="${listPartsOffers !=null}">
            <c:forEach items="${listPartsOffers}" var="partsOffer">
                <table class="table table-hover">
                <tr>
                        <%--  <form action="/cart/add/${partsOffer.offer_id}" method="get"> --%>

                    <td>
                            ${partsOffer.offer_price} ${partsOffer.currency}
                    </td>
                    <td>
                        <a href="/cart/add/${partsOffer.offer_id}"
                           class="btn btn-primary glyphicon glyphicon-shopping-cart" role="button">${put_to_cart}</a>
                    </td>
                    <td>
                            ${partsOffer.vendor.vendor_name}
                    </td>

                        <%--</form>--%>
                </tr>
                </table>
            </c:forEach>
    </c:if>
</div>
