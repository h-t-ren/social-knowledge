<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html;charset=UTF-8"%>
<div id="modalDialogContainer">
<form:form modelAttribute="author">
<fieldset><legend>Add an author from existing users or from creating new...</legend>

<div>
  <fieldset><legend>select author from the list</legend>
   <select dojoType="dijit.form.FilteringSelect" id="idExistAuthor" name="idExistAuthor">
	  <c:forEach var="author" items="${authors}">
		 <option value="${author.id}"> <c:out value="${author.firstName}" />, <c:out value="${author.lastName}" /></option>
	  </c:forEach>
  </select>
    <p><button id="addAuthor" type="submit" name="_eventId_addAuthor">Add</button><button id="cancel" type="submit" name="_eventId_cancel">Cancel</button></p>
  </fieldset>
</div>


<div>
   <tiles:insertAttribute name="authorFormFragment"/>
</div>

</fieldset>

</form:form>

  	<script type="text/javascript">
		Spring.addDecoration(new Spring.AjaxEventDecoration({
			elementId: "addAuthor",
			event: "onclick",
			params: {fragments: "body"}		
		}));
	</script>
	
  <script type="text/javascript">
      dojo.require("dijit.form.FilteringSelect");
  </script>
</div>