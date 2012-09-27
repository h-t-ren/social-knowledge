<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title><fmt:message key="app_title" /></title>
	<link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/blueprint/screen.css" />" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<c:url value="/resources/styles/blueprint/print.css" />" type="text/css" media="print" />
	<!--[if lt IE 8]>
	        <link rel="stylesheet" href="<c:url value="/resources/blueprint/ie.css" />" type="text/css" media="screen, projection" />
	<![endif]-->
    <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />" djConfig="parseOnLoad: true"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>
    <link rel="stylesheet" href="<c:url value="/resources/styles/ime-web.css" />" type="text/css" media="screen" />
    <link rel="stylesheet" href="<c:url value="/resources/styles/login.css" />" type="text/css" media="screen" />
	
<style type="text/css">
 html,body {width: 100%; height: 100%;margin: 0;overflow: hidden;}
 #reporting {
    position: absolute;
    top: 55px;
    right: 20px;
    font: 12px Arial, Verdana;
    color: #666;
}
</style>
  
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery-1.4.4.min.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery.jeditable.js" />"></script>
		<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/table/jquery.dataTables.editable.js" />"></script>	
		<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/table/jquery.validate.js" />"></script>	
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery-ui-1.8.10.custom.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery.blockUI.js" />"></script>
<link type="text/css" href="<c:url value="/resources/javascript/jquery/jquery-ui-1.8.10.custom.css" />" rel="stylesheet" />	
<script type="text/javascript" src="<c:url value="/resources/javascript/jquery/table/jquery.dataTables.js" />"></script>	
		
<link rel="stylesheet" href="<c:url value="/resources/javascript/jquery/table/table.css" />" type="text/css" media="screen, projection" />

	<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery.comboselect.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery.selso.js" />"></script>
<link rel="stylesheet"
	href="<c:url value="/resources/styles/ime_left_menu-style.css" />" type="text/css"
	media="screen" />
<link rel="stylesheet"
	href="<c:url value="/resources/javascript/jquery/jquery.comboselect.css" />" type="text/css"
	media="screen" />
 <link type="text/css" href="<c:url value="/resources/javascript/jquery/jquery.countdown.css" />" rel="stylesheet" />	
<script type="text/javascript"  src="<c:url value="/resources/javascript/jquery/jquery.countdown.js"/>"></script>

</head>

<body class="tundra">
<div dojoType="dijit.layout.BorderContainer" id="borderContainer">

  <div id="header_toolbar" dojoType="dijit.layout.ContentPane" region="top" isLayoutContainer="true" >
  <%@ include file="header.jsp" %>
  </div>
  <div id="app_body" dojoType="dijit.layout.ContentPane" region="center">
     <tiles:insertAttribute name="body" />
  </div>
  <div dojoType="dijit.layout.ContentPane" region="bottom">
   <div id="footer_msg">${viewState.whereWeAre}</div>
   <div id="footer_copyrights"><fmt:message key="copyright" /> &copy; 2010-<script type="text/javascript"> var d = new Date();document.write(d.getFullYear());</script> &nbsp; <fmt:message key="company" /></div>
  </div>
</div>
</body>

<script type="text/javascript">
        dojo.require("dijit.layout.ContentPane");
        dojo.require("dijit.layout.BorderContainer");
        dojo.require("dijit.layout.LayoutContainer");

</script>


</html>