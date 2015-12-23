<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<spring:message code="label.login" var="login"/>
<spring:message code="label.logout" var="logout"/>
<spring:message code="label.auth_login" var="auth_login"/>
<spring:message code="label.auth_passw" var="auth_passw"/>
<spring:message code="label.auth_incorrect_login" var="auth_incorrect_login"/>
<spring:message code="label.auth_incorrect_passw" var="auth_incorrect_passw"/>
<spring:message code="label.forgot_passw" var="forgot_passw"/>
<spring:message code="label.remember_me" var="remember_me"/>
<spring:url var="logoutUrl" value="/j_spring_security_logout"/>
<c:url value="/j_spring_security_check" var="loginUrl"/>

<form class="form-inline">
    <div class="form-group">
            <a href="?lang=en_US">English</a>|<a href="?lang=ru_RU">Русский</a>
    </div>
    <div class="form-group col-lg-offset-2">
        <sec:authorize access="!isAuthenticated()">
            <!-- DROPDOWN LOGIN STARTS HERE -->
                    <button type="button" id="dropdownMenu1" data-toggle="dropdown"
                            class="btn btn-default navbar-btn dropdown-toggle">
                        <i class="glyphicon glyphicon-user color-blue"></i> ${login} <span class="caret"></span>
                    </button>
                    <ul class="dropdown-menu">
                        <li>
                            <div class="container" style="width: 300px; height: auto">
                                <form action="${loginUrl}" method="post" role="form" style="height: auto">
                                    <div class="form-group">
                                        <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-user color-blue"></i>
                                                </span>
                                            <!--LOGIN-->
                                            <input id="login" name="j_username"
                                                   placeholder=${auth_login} class="form-control"
                                                   type="login"
                                                   oninvalid="this.setCustomValidity(validity.valueMissing ? '${auth_incorrect_login}' : '');"
                                                   onchange="this.setCustomValidity(validity.valueMissing ? '${auth_incorrect_login}' : '');"
                                                   required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <div class="input-group">
                                                <span class="input-group-addon">
                                                    <i class="glyphicon glyphicon-lock color-blue"></i>
                                                </span>
                                            <!--PASSWORD-->
                                            <input id="password" name="j_password"
                                                   placeholder=${auth_passw} class="form-control"
                                                   type="password"
                                                   oninvalid="this.setCustomValidity(validity.valueMissing ? '${auth_incorrect_passw}' : '');"
                                                   onchange="this.setCustomValidity(validity.valueMissing ? '${auth_incorrect_passw}' : '');"
                                                   required="">
                                        </div>
                                    </div>
                                    <div class="form-group">
                                        <!--BUTTON-->
                                        <button type="submit" class="btn btn-primary form-control">${login}</button>
                                    </div>
                                    <div class="form-group">
                                        <!--RESET PASSWORD LINK-->
                                            <span class="pull-left">
                                                <input id="remember_me" name="_spring_security_remember_me"
                                                       type="checkbox"/>${remember_me}
                                            </span>
                                        <!-- Флажок "запомнить меня" -->
                                            <span class="pull-right">
                                                <a href="#">${forgot_passw}</a>
                                            </span>
                                    </div>
                                </form>
                            </div>
                        </li>
                    </ul>

        </sec:authorize>
        <sec:authorize access="isAuthenticated()">
            <a href=${logoutUrl}>${logout}</a>
        </sec:authorize>
        </div>
</form>
