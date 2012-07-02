<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html;charset=UTF-8"%>
<form:form>

<fieldset>
    	<legend>New publication</legend>
        <dl>
        	<dt><label for="title">title:</label></dt>
            <dd><input type="text" name="title" id="title" size="32" maxlength="128" /></dd>
        </dl>
        <dl>
        	<dt><label for="bibtex">bibtex:</label></dt>
            <dd><input type="text" name="bibtex" id="bibtex" size="32" maxlength="32" /></dd>
        </dl>
      <c:forEach var="field" items="${fields}">
         <dl>
        	<dt><label for="${field.name}">${field.name}:</label></dt>
            <dd><input type="text" name="${field.name}" id="${field.name}" size="32" maxlength="32" /></dd>
          </dl>
      </c:forEach>

    </fieldset>
</form:form>