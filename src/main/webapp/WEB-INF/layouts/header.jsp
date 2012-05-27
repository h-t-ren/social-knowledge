<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
  
  <!-- define urls -->
    <c:url var="englishLocaleUrl" value="/"><c:param name="locale" value="" /></c:url> 
    <c:url var="chineseLocaleUrl" value="/"><c:param name="locale" value="cn" /></c:url>
    <c:url var="login" value="/login/login" />
    <c:url var="logout" value="/login/logout" />
    <c:url var="admin" value="/admin/dashboard" />
	<c:url var="browse" value="/browse/dashboard" />
	<c:url var="newData" value="/newdata/dashboard" />
    
  <div id="nav_top">
  <div id="app_area" >
    <fmt:message key="app_name" />
   </div>
   <div id="other_area">
   (<a id="headerActiveLink" href='<c:out value="${englishLocaleUrl}"/>'>English</a>|
   <a id="headerActiveLink" href='<c:out value="${chineseLocaleUrl}"/>'>中文</a>)&nbsp; 
   
   <security:authorize access="hasRole('ROLE_USER')">
	<c:if test="${pageContext.request.userPrincipal != null}">
		<fmt:message key="welcome" />, ${pageContext.request.userPrincipal.name} |
		<a id="headerActiveLink" href="${logout}"><fmt:message key="logout" /></a>
	</c:if>
    </security:authorize>
   
   <security:authorize access="isAnonymous()">
	<a id="headerActiveLink" href="${login}"><fmt:message key="login" /></a>
  </security:authorize>
  </div>
</div>

<div id="navmenu">
<ul id="nav">
        <security:authorize access="hasRole('ROLE_ADMIN')">
      	<li><a class="headerActiveLink" href="${admin}"><fmt:message key="admin" /></a></li>
      </security:authorize>
	   <security:authorize access="hasRole('ROLE_USER')">
      	<li><a class="headerActiveLink" href="${browse}"><fmt:message key="browse" /></a></li>
 	  	<li><a class="headerActiveLink" href="${newData}"><fmt:message key="newData" /></a></li>
     </security:authorize>
</ul>

</div>

