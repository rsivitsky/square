<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/part/photo" var="partPhotoUrl"/>
<spring:url value="/part/description/${part[0]}" var="partInfo"/>
<spring:message code="label.vendors" var="number_sellers"/>

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
                <label class="control-label">${part[2]} - ${part[3]}</label>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12">
                <label class="control-label">${number_sellers}: ${part[4]}</label>
            </div>
        </div>
    </c:if>
    <c:if test="${!empty listPartsOffers}">
    <table class="table table-hover">
        <c:forEach items="${listPartsOffers}" var="partsOffer">
        <tr>
            <td>
                    ${partsOffer.offer_price}
            </td>
            <td>
                    ${partsOffer.currency.valuta_name}
            </td>
            <td>
                    ${partsOffer.vendor.vendor_name}
            </td>
        </tr>
        </c:forEach>
        <table>
            </c:if>
</div>
