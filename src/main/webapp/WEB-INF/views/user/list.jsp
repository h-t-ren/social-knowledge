<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript" charset="utf-8">
$(document).ready(
 function(){
$('#highlight').dataTable(
{
"sPaginationType": "full_numbers"
}
);
 }
);

</script>

<fieldset><legend>User list:</legend>
  <table class="display" id="highlight">
        <thead>
          <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Login</th>
            <th>Password</th>
            <th>Role(s)</th>
            <th>Operation</th>
            </tr>
        </thead>
        <tbody>
       
        <c:forEach var="user" items="${users.user}">
            <tr>
                <td>${user.id}</td>
                <td>${user.name}</td>
                <td>${user.login}</td>
                <td>${user.password}</td>
                <td>${user.roles}</td>
           
               <td> <a href="<c:url value="/userForm?id=${user.id}" />">
                 <img src="<c:url value="/resources/images/crud/edit.png"/>" title="Edit this user" />
               </a>
               </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</fieldset>
