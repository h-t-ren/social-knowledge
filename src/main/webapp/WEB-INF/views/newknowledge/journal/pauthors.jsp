<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
	<div>
			<p>
				Authors/Editors:
			</p>
			<c:forEach items="${publication.authors}" var="author">
                     <c:out value="${author.firstName}" />, <c:out value="${author.lastName}" />&nbsp;
            </c:forEach>
            
    <input type="submit" name="_eventId_addAuthors" id="addAuthors" value="Add" />
  <!--  <a id="addAuthor" href="${flowExecutionUrl}&_eventId=addAuthor" >Add authors</a>-->
  <!-- need to be solved, button popup does not work -->
	<script type="text/javascript">
		Spring.addDecoration(new Spring.AjaxEventDecoration({
			elementId: "addAuthors",
			event: "onclick",
			popup:true,
			params: {fragments: "body"}		
		}));
	</script>
	</div>