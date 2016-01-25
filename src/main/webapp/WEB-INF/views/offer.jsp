<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>measure Page</title>
    <style type="text/css">
        .tg {
            border-collapse: collapse;
            border-spacing: 0;
            border-color: #ccc;
        }

        .tg td {
            font-family: Arial, sans-serif;
            font-size: 14px;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #fff;
        }

        .tg th {
            font-family: Arial, sans-serif;
            font-size: 14px;
            font-weight: normal;
            padding: 10px 5px;
            border-style: solid;
            border-width: 1px;
            overflow: hidden;
            word-break: normal;
            border-color: #ccc;
            color: #333;
            background-color: #f0f0f0;
        }

        .tg .tg-4eph {
            background-color: #f9f9f9
        }
    </style>
</head>
<body>
<h1>
    Add a offer
</h1>

<c:url var="addAction" value="/offers/add"></c:url>

<form:form action="${addAction}" commandName="offer">
    <table>
        <tr>
            <td>
                <form:label path="offer_date">
                    <spring:message text="offerDate"/>
                </form:label>
            </td>
            <td>
                <form:input path="offer_date"/>
            </td>
        </tr>
        <tr>
            <form:label path="currency">
                <spring:message text="offerDate"/>
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
                     <form:input path="offer_num"/>
                 </td>
             </tr>
             <tr>
                 <td>
                     <form:label path="offer_sum">
                         <spring:message text="summ"/>
                     </form:label>
                 </td>
                 <td>
                     <form:input path="offer_sum"/>
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
    <table class="data">
        <tr>
            <th width="80">id</th>
            <th width="120">date</th>
            <th width="60">delete</th>
        </tr>
        <c:forEach items="${listOffers}" var="offer_item">
            <tr>
                <td>${offer_item.offer_id}</td>
                <td>${offer_item.date_name}</td>
                <td><a href="<c:url value='/offer/edit/${offer_item.offer_id}' />">Edit</a></td>
                <td><a href="<c:url value='/offer/remove/${offer_item.offer_id}' />">Delete</a></td>
            </tr>
        </c:forEach>
    </table>
</c:if>
</body>
</html>
