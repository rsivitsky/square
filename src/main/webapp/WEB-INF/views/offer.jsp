<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<c:url var="addAction" value="/offers/add"></c:url>
<div>
    <form:form action="${addAction}" commandName="offer">
        <table>
            <tr>
                <td>
                    <form:label path="offer_date">
                        <spring:message text="offer's date"/>
                    </form:label>
                </td>
                <td>
                    <form:input type="date" path="offer_date"/>
                </td>
            </tr>
            <tr>
                <form:label path="currency">
                    <spring:message text="currency"/>
                </form:label>
                <td>
                    <form:select path="currency.valuta_id" name="currency" items="${listCurrency}" itemValue="valuta_id"
                                 itemLabel="valuta_name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="offer_price">
                        <spring:message text="price"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="offer_price"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="part">
                        <spring:message text="part"/>
                    </form:label>
                </td>
                <td>
                    <form:select path="part.part_id" name="part" items="${listPart}" itemValue="part_id"
                                 itemLabel="part_name"/>
                </td>
            </tr>

            <tr>
                <td>
                    <form:label path="vendor">
                        <spring:message text="vendor"/>
                    </form:label>
                </td>
                <td>
                    <form:select path="vendor.vendor_id" name="vendor" items="${listVendor}" itemValue="vendor_id"
                                 itemLabel="vendor_name"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="offer_num">
                        <spring:message text="num"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="offer_num" name="offer_num"/>
                </td>
            </tr>
            <tr>
                <td>
                    <form:label path="offer_sum">
                        <spring:message text="summ"/>
                    </form:label>
                </td>
                <td>
                    <form:input path="offer_sum" name="offer_sum"/>
                </td>
            </tr>
            <tr>
                <c:if test="${!empty offer.offer_id}">
                    <input type="submit"
                           value="<spring:message text="Edit"/>"/>
                </c:if>
                <c:if test="${empty offer.offer_id}">
                    <input type="submit"
                           value="<spring:message text="Add"/>"/>
                </c:if>
            </tr>
        </table>
    </form:form>

    <c:if test="${!empty listOffers}">
        <br>

        <h3>offer list</h3>
        <table class="table table-hover table-responsive">
            <tr>
                <th width="80">id</th>
                <th width="120">date</th>
                <th width="120">currensy</th>
                <th width="60">delete</th>
            </tr>
            <c:forEach items="${listOffers}" var="offer_item">
                <tr>
                    <td>${offer_item.offer_id}</td>
                    <td><fmt:formatDate pattern="dd-MM-yyyy"
                                    value="${offer_item.offer_date}" /></td>
                    <td>${offer_item.currency.valuta_name}</td>
                    <td><a href="<c:url value='/offers/edit/${offer_item.offer_id}' />">Edit</a></td>
                    <td><a href="<c:url value='/offers/remove/${offer_item.offer_id}' />">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
    </c:if>
</div>