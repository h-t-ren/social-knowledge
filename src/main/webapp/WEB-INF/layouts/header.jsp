<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
    <c:url var="englishLocaleUrl" value="/">
	    <c:param name="locale" value="" />
     </c:url> 
    <c:url var="chineseLocaleUrl" value="/">
	    <c:param name="locale" value="cn" />
    </c:url>
<div id="nav_top">
  <div id="app_area" >
    <fmt:message key="app_name" />
   </div>
   <div id="other_area">

   (<a id="headerActiveLink" href='<c:out value="${englishLocaleUrl}"/>'>English</a>|
   <a id="headerActiveLink" href='<c:out value="${chineseLocaleUrl}"/>'>中文</a>)&nbsp; 
   
   <security:authorize ifAllGranted="ROLE_USER">
	<c:if test="${pageContext.request.userPrincipal != null}">
		<fmt:message key="welcome" />, ${pageContext.request.userPrincipal.name} |
	</c:if>
	<a id="headerActiveLink" href="<c:url value="/login/logout" />"><fmt:message key="logout" /></a>
   </security:authorize> 
   <security:authorize ifAllGranted="ROLE_ANONYMOUS">
	<a id="headerActiveLink" href="<c:url value="/login/login" />"><fmt:message key="login" /></a>
  </security:authorize>
  </div>
</div>

<div id="navmenu">
<ul id="nav">
      <security:authorize ifAllGranted="ROLE_ADMIN">
      	<li><a class="headerActiveLink" href="<c:url value="/admin/dashboard" />"><fmt:message key="admin" /></a></li>
      </security:authorize>
	<!--  <li><a class="headerDisabledLink"><fmt:message key="home" /></a></li>-->
	 <security:authorize ifAllGranted="ROLE_USER">
     <c:choose>
     <c:when test="${viewState.activeLevel==1}">
      	<li><a class="headerActiveLink" href="<c:url value="/prob" />"><fmt:message key="problem" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="instance" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="analysis" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="tasks" /></a></li>
     </c:when>
      <c:when test="${viewState.activeLevel==2}">
      	<li><a class="headerActiveLink" href="<c:url value="/prob" />"><fmt:message key="problem" /></a></li>
 	    <li><a class="headerActiveLink" href="<c:url value="/instance?idProb=${idProb}" />"><fmt:message key="instance" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="analysis" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="tasks" /></a></li>
     </c:when>
      <c:when test="${viewState.activeLevel==3}">
      	<li><a class="headerActiveLink" href="<c:url value="/prob" />"><fmt:message key="problem" /></a></li>
 	    <li><a class="headerActiveLink" href="<c:url value="/instance?idProb=${idProb}" />"><fmt:message key="instance" /></a></li>
 	    <li><a class="headerActiveLink" href="<c:url value="/analysis?idProb=${idProb}&idInstance=${idInstance}" />"><fmt:message key="analysis" /></a></li>
 	    <li><a class="headerActiveLink"><fmt:message key="tasks" /></a></li>
     </c:when>
     <c:otherwise>
        <li><a class="headerActiveLink" href="<c:url value="/prob" />"><fmt:message key="problem" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="instance" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="analysis" /></a></li>
 	    <li><a class="headerDisabledLink"><fmt:message key="tasks" /></a></li>
     </c:otherwise>
     </c:choose>
     </security:authorize>


</ul>

</div>

