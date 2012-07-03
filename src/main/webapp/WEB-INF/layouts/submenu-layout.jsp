<!DOCTYPE html>
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
  
   <script type="text/javascript" src="<c:url value="/resources/javascript/jquery/jquery.min.js" />"></script>
   <script type="text/javascript" src="<c:url value="/resources/javascript/jquery/jquery-ui.min.js" />"></script>
   <script type="text/javascript" src="<c:url value="/resources/javascript/jquery/jqcloud-1.0.0.min.js" />"></script>

<link rel="stylesheet"
	href="<c:url value="/resources/styles/ime_left_menu-style.css" />" type="text/css"
	media="screen" />
    <script src="<c:url value="/resources/neo/js/ui.js"/>"></script>
    <script src="<c:url value="/resources/neo/js/processing.min.js"/>"></script>
    <link href="<c:url value="/resources/neo/css/global.css"/>" rel='stylesheet'>
    <link href="<c:url value="/resources/javascript/css/jqcloud.css"/>" rel='stylesheet'>
    
    
    
    
    
    
 <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/javascript/jqgrid/css/jquery-ui/pepper-grinder/jquery-ui-1.8.16.custom.css"/>'/>
<link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/javascript/jqgrid/css/ui.jqgrid-4.3.1.css"/>'/>
<!--  
<script type='text/javascript' src='<c:url value="/resources/javascript/jqgrid/js/jquery-1.6.4.min.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/javascript/jqgrid/js/jquery-ui-1.8.16.custom.min.js"/>'></script>
-->
<script type='text/javascript' src='<c:url value="/resources/javascript/jqgrid/js/grid.locale-en-4.3.1.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/javascript/jqgrid/js/jquery.jqGrid.min.4.3.1.js"/>'></script>
<script type='text/javascript' src='<c:url value="/resources/javascript/jqgrid/js/custom.js"/>'></script>

    
    
    
  <script type="text/javascript"
	src="<c:url value="/resources/javascript/niceforms.js" />"></script>  
    <link rel="stylesheet" type="text/css" media="screen" href='<c:url value="/resources/javascript/css/niceforms-default.css"/>'/>
    
</head>


<body class="tundra">
<div dojoType="dijit.layout.BorderContainer" id="borderContainer">

  <div id="header_toolbar" dojoType="dijit.layout.ContentPane" region="top" isLayoutContainer="true">
  <%@ include file="header.jsp" %>
  </div>
    <div id="app_leading" dojoType="dijit.layout.ContentPane" region="leading">
      <tiles:insertAttribute name="submenu" />
  </div>
  <div id="app_body" dojoType="dijit.layout.ContentPane" region="center">
     <tiles:insertAttribute name="body" />
  </div>
<div dojoType="dijit.layout.ContentPane" region="bottom">
   <div id="footer_msg">${viewState.whereWeAre}</div>
   <div id="footer_copyrights">Copyright &copy; 2010-<script type="text/javascript"> var d = new Date();document.write(d.getFullYear());</script> &nbsp; IME,IIASA</div>
  </div>
</div>
</body>
<script type="text/javascript">
        dojo.require("dijit.layout.ContentPane");
        dojo.require("dijit.layout.BorderContainer");
        dojo.require("dijit.layout.LayoutContainer");
        dojo.require("dijit.form.Textarea");
		dojo.require("dojo.parser");
</script>

    <style type="text/css">
      #wordcloud {
        margin: 30px auto;
        width: 600px;
        height: 371px;
        border: none;
      }
      #wordcloud span.w10, #wordcloud span.w9, #wordcloud span.w8, #wordcloud span.w7 {
        text-shadow: 0px 1px 1px #ccc;
      }
      #wordcloud span.w3, #wordcloud span.w2, #wordcloud span.w1 {
        text-shadow: 0px 1px 1px #fff;
      }
    </style>

</html>