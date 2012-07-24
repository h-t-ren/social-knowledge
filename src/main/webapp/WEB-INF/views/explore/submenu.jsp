<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@page import="com.huaxinshengyuan.socknow.userdetails.SocknowUserDetails" %>
<%
SocknowUserDetails sockUser = (SocknowUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
%>
<a href='<c:url value="/graph?id="/><%=sockUser.getUser().getId()%>'>My Knowledge map</a><br/>
<a href='<c:url value="/explore/tagcloud"/>'>My cloud</a><br/>
<a href='<c:url value="/explore/ajaxtest"/>'>My Groups</a><br/>
<a href='<c:url value="/explore/ajaxtest"/>'>My Favorites</a><br/>
<a href='<c:url value="/explore/ajaxtest"/>'>My Potential collaborators</a><br/>
<a href='<c:url value="/explore/ajaxtest"/>'>Knowledge discovery</a>
