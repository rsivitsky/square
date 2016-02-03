<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<div class="col-md-12">
    <c:if test="${!empty listPartsOffers}">
    <table class="table table-hover">
        <c:forEach items="${listPartsOffers}" var="partsOffer">
            <tr>
                <td>
                        ${partsOffer.part.part_name}
                </td>
                <td>
                        ${partsOffer.vendor.vendor_name}
                </td>
                <td>
                        ${partsOffer.offer_price}
                </td>
            </tr>
        </c:forEach>
    <table>
        </c:if>
</div>
