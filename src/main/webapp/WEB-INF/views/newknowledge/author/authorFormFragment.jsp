<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@page contentType="text/html;charset=UTF-8"%>
   <fieldset><legend>create a new author</legend>
	   <table id="publform">
	   <tr>
	   <th>First name (English):</th><td><form:input path="firstName"/></td></tr>
	   <tr><th>Last name (English):</th><td><form:input path="lastName"/></td></tr>
	   <tr><th>Institution:</th><td><form:input path="institution"/></td>
	   <tr><th>email:</th><td><form:input path="email"/></td></tr>
	   <tr><th>First name (Chinese):</th><td><form:input path="otherFirstName"/></td></tr>
	   <tr><th>Last name(Chinese):</th><td><form:input path="otherLastName"/></td></tr>
	   </table>
    <p><button id="createAuthor" type="submit" name="_eventId_createAuthor">Create</button><button id="cancel" type="submit" name="_eventId_cancel">Cancel</button></p>
   </fieldset>
