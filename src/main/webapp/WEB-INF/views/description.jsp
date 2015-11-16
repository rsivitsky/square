<%@ page language="java" contentType="text/html; charset=utf8"
         pageEncoding="utf8"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <title>New description</title>
  <style type="text/css">
    .tg  {border-collapse:collapse;border-spacing:0;border-color:#ccc;}
    .tg td{font-family:Arial, sans-serif;font-size:14px;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#fff;}
    .tg th{font-family:Arial, sans-serif;font-size:14px;font-weight:normal;padding:10px 5px;border-style:solid;border-width:1px;overflow:hidden;word-break:normal;border-color:#ccc;color:#333;background-color:#f0f0f0;}
    .tg .tg-4eph{background-color:#f9f9f9}
  </style>
</head>
<body>
<c:url var="addAction" value="/part/descript/add" ></c:url>

<form:form action="${addAction}" commandName="description">
  <table>
    <tr>
      <td>
        <form:label path="part">
          <spring:message text="part_id"/>
        </form:label>
      </td>
      <td>
        <form:input path="part.part_id" disabled="true"/>
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="descript_name">
          <spring:message text="descript name"/>
        </form:label>
      </td>
      <td>
        <form:input path="descript_name" />
      </td>
    </tr>
    <tr>
      <td>
        <form:label path="descript_value">
          <spring:message text="descript_value"/>
        </form:label>
      </td>
      <td>
        <form:input path="descript_value" />
      </td>
    </tr>
    <tr>
        <input type="submit"
               value="<spring:message text="Add description"/>" />
    </tr>
  </table>
</form:form>
</body>
</html>
