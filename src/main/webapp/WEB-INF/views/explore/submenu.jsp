<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>
<%@page import="com.huaxinshengyuan.socknow.userdetails.SocknowUserDetails" %>

<%
SocknowUserDetails sockUser = (SocknowUserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();

%>
<a href='<c:url value="/graph?id="/><%=sockUser.getUser().getId()%>'>My map</a><br/>
<a href='<c:url value="/explore/tagcloud"/>'>Tag cloud</a>
