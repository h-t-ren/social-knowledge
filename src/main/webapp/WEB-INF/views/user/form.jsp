<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<form:form modelAttribute="user">
	<fieldset>
    	<legend>User</legend>
  <div>
		<div>
			<p>
				Name:
			</p><form:input path="name" size="60" maxlength="128" />
		</div>
		<div>
			<p>
				login:
		    </p> <form:input path="login" size="60" maxlength="128"/>
		</div>
		<div class="hr">
			<!-- spanner -->
		</div>
		
		<button type="submit" name="_eventId_save">Save</button>
   </div>
      
    </fieldset>
  </form:form>
  

