<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<sec:authorize access="!isAuthenticated()">
  <div class="container" style="width: 300px;">
    <c:url value="/j_spring_security_check" var="loginUrl"/>
    <form action="${loginUrl}" method="post">
      <table>
        <tr>
          <th><label for="login">Login</label></th>
          <td>
            <input type="text" class="form-control" id="login" name="j_username" placeholder="login"
                   required autofocus>
          </td>
        </tr>
        <tr>
          <th><label for="password">Password</label></th>
          <td>
            <input type="password" class="form-control" id="password" name="j_password"
                   placeholder="password" required>
          </td>
        </tr>
        <tr>
          <th></th>
          <td>
            <label for="remember_me"
                   class="inline">Remember me</label>
            <input id="remember_me"
                   name="_spring_security_remember_me"
                   type="checkbox"/>
          </td>
        </tr>
      </table>
      <button class="btn btn-lg btn-primary btn-block" type="submit">Sign in</button>
    </form>
  </div>
</sec:authorize>