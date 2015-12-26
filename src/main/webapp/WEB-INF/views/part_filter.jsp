<%@page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<div class="row">
  <form role="form">
    <div class="checkbox">
      <label>
        <input type="checkbox" value="check1" onchange="">
        Обычный чекбокс, который можно отметить
      </label>
    </div>
    <div class="checkbox disabled">
      <label>
        <input type="checkbox" value="check2" disabled>
        Заблокированный чекбокс, не отмечается
      </label>
    </div>
    <select class="form-control" multiple>
      <option>1</option>
      <option>2</option>
      <option>3</option>
      <option>4</option>
      <option>5</option>
    </select>
  </form>
</div>
