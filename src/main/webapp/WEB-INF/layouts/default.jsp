<html xmlns:jsp = "http://java.sun.com/JSP/Page"
      xmlns:c = "http://java.sun.com/jsp/jstl/core"
      xmlns:fn = "http://java.sun.com/jsp/jstl/functions"
      xmlns:tiles = "http://tiles.apache.org/tags-tiles"
      xmlns:spring = "http://www.springframework.org/tags">
<jsp:output doctype-root-element = "HTML"
            doctype-system = "about:legacy-compat" />
<jsp:directive.page contentType = "text/html;charset = UTF-8" />
<jsp:directive.page pageEncoding="UTF-8" />
<head>
  <meta http-equiv = "Content-Type" content = "text/html; charset = UTF-8" />
  <meta http-equiv="X-UA-CompatiЫe" content = "IE = B" />
  <spring:theme code = "styleSheet" var = "app_css" />
  <spring:url value = "/${app_css}" var = "app_css_url" />
  <link rel = "stylesheet" type = "text/css" media = "screen"
        href = "${app_css_url}" />
  <!-- Извлечь пользовательскую локаль из контекста страницы
  (она бЬUJа установлена распознавателем локалей Spring MVC) -->654
  Глава 16. Разработка веб-приложений в Spring
  <c:set var="userLocale">
    <c:set var = "plocale">${pageContext.response.locale}</c:set>
    <с: out value = " $ { fn: replace (plocale, ' ', ' - ') } " defaul t="en" />
  </c:set>
  <%--<spring:message code = "application_name" var="app_name"
                  htmlEscape="false"/>
  <title><spring:message code="welcome hЗ" arguments="${app_name}" />
  </title>--%>
</head>
<body class = "tundra spring">
<div id="headerWrapper">
  <tiles:insertAttribute name = "header" ignore="true" />
</div>
<div id="wrapper">
  <tiles:insertAttribute name="menu" ignore="true" />
  <div id = "main">
    <tiles:insertAttribute name = "body"/>
    <tiles:insertAttribute name = "footer" ignore = "true"/>
  </div>
</div>
</body>
</html>