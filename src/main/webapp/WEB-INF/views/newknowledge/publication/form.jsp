<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html;charset=UTF-8"%>
<form:form>
   <fieldset><legend>create a new publication</legend>
	   <table>
	   <tr>
	   <th>publication:</th><td>
	   <c:forEach var="field" items="${fields}">
	      ${field.name} ,,,
	   </c:forEach>
	   
	   </td></tr>

	   </table>
    <p><button id="createJournal" type="submit" name="_eventId_createJournal">Create</button></p>
   </fieldset>

</form:form>