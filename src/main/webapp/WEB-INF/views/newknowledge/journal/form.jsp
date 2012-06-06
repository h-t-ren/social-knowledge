<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html;charset=UTF-8"%>
<form:form modelAttribute="journal">
   <fieldset><legend>create a new journal</legend>
	   <table id="publform">
	   <tr>
	   <th>name:</th><td><form:input path="name"/></td></tr>
	   <tr><th>abbreviation:</th><td><form:input path="abbreviation"/></td></tr>
	   <tr><th>ISSN:</th><td><form:input path="ISSN"/></td>
	  
	   </table>
    <p><button id="createJournal" type="submit" name="_eventId_createJournal">Create</button></p>
   </fieldset>

</form:form>