<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<spring:url value="/part/photo" var="partPhotoUrl"/>
<spring:url value="/part/description/${part.part_id}" var="partInfo"/>
<spring:message code="label.vendors" var="number_sellers"/>

<spring:message code="label.vendors" var="number_sellers"/>

<div class="col-md-12">
    <c:if test="${part != null}">
        <div class="row">
            <div class="col-md-4">
                <a href="${partDescription}"><img src="${partPhotoUrl}/${part.part_id}" class="img-rounded" height="40"
                                                  width="150"/></a>
            </div>
            <div class="col-md-4">
                <label class="control-label">${part.part_name}</label>
            </div>
        </div>
        <br>
    </c:if>

    <c:if test="${!empty descriptions}">
    <table class="table table-hover">
        <c:forEach items="${descriptions}" var="description">
        <tr>
            <td>
                    ${description.descript_name}
            </td>
            <td>
                    ${description.descript_value} ${description.specification.measure.measure_name}
            </td>
        </tr>
        </c:forEach>
        <table>
            </c:if>
</div>