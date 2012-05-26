<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<title>IME-MCMA</title>

<link type="text/css" rel="stylesheet" href="<c:url value="/resources/dijit/themes/tundra/tundra.css" />" />

<link rel="stylesheet"
	href="<c:url value="/resources/styles/layout-default-latest.css" />"
	type="text/css" media="screen, projection" />

<link rel="stylesheet"
	href="<c:url value="/resources/styles/blueprint/screen.css" />"
	type="text/css" media="screen, projection" />
<link rel="stylesheet"
	href="<c:url value="/resources/styles/blueprint/print.css" />"
	type="text/css" media="print" />

<link rel="stylesheet"
	href="<c:url value="/resources/styles/ime-web.css" />" type="text/css"
	media="screen" />

<link rel="stylesheet"
	href="<c:url value="/resources/styles/mca.css" />" type="text/css"
	media="screen" />
	
<link rel="stylesheet"
	href="<c:url value="/resources/styles/ime_left_menu-style.css" />"
	type="text/css" media="screen" />

    <script type="text/javascript" src="<c:url value="/resources/dojo/dojo.js" />" djConfig="parseOnLoad: true"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring.js" />"></script>
    <script type="text/javascript" src="<c:url value="/resources/spring/Spring-Dojo.js" />"></script>


      <script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/jquery-1.7.1.js" />"></script>

 <script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery-1.4.4.min.js" />"></script>
<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery-ui-latest.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/javascript/jquery/jquery.layout-latest.js" />"></script>

<script type="text/javascript"
	src="<c:url value="/resources/javascript/overlib/overlib.js" />"></script>
	
	
	
	
	<link rel="stylesheet" href="<c:url value="/resources/javascript/slide/css/jslider.css" />" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<c:url value="/resources/javascript/slide/css/jslider.blue.css" />" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<c:url value="/resources/javascript/slide/css/jslider.plastic.css" />" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<c:url value="/resources/javascript/slide/css/jslider.round.css" />" type="text/css" media="screen, projection" />
	<link rel="stylesheet" href="<c:url value="/resources/javascript/slide/css/jslider.round.plastic.css" />" type="text/css" media="screen, projection" />

	<script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/jshashtable-2.1_src.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/jquery.numberformatter-1.2.3.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/tmpl.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/jquery.dependClass-0.1.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/draggable-0.1.js" />"></script>
	<script type="text/javascript"
	src="<c:url value="/resources/javascript/slide/js/jquery.slider.js" />"></script>

	
	

<SCRIPT type="text/javascript">
var myLayout, innerLayout;

$(document).ready(function () {

		myLayout = $('body').layout({

			//	reference only - these options are NOT required because 'true' is the default
				closable:				true	// pane can open & close
			,	resizable:				true	// when open, pane can be resized 
			,	slidable:				true	// when closed, pane can 'slide' open over other panes - closes on mouse-out

			//	some resizing/toggling settings
			,	north__slidable:		false	// OVERRIDE the pane-default of 'slidable=true'
			,	north__spacing_closed:	2		// big resizer-bar when open (zero height)
			,	north__spacing_open:	2		// big resizer-bar when open (zero height)
			,	south__resizable:		false	// OVERRIDE the pane-default of 'resizable=true'
			,	south__spacing_open:	2		// no resizer-bar when open (zero height)
			,	south__spacing_closed:	2		// big resizer-bar when open (zero height)
			//	some pane-size settings
			,	west__minSize:			500
			,   center__onresize:		"innerLayout.resizeAll" 
			});	
		myLayout.sizePane("west", 580);
		myLayout.sizePane("south", 50);
		
		innerLayout = $('div.middle-center').layout({ 	
				    closable:				true	// pane can open & close
				,	resizable:				true	// when open, pane can be resized 
				,	slidable:				true	// when closed, pane can 'slide' open over other panes - closes on mouse-out
                ,   spacing_open:			0  
     			,	spacing_closed:			0
			}); 

});
</SCRIPT>


</head>

<body class="tundra">
	<div class="ui-layout-north" id="header_toolbar"><%@ include
			file="header.jsp"%></div>
	<form:form id="_form">
		<div class="ui-layout-west">
			<tiles:insertAttribute name="submenu" />
		</div>
		<div class="ui-layout-center">
			<div class="middle-center" style="height: 100%; width: 100%;">
				<div class="ui-layout-center">
					<tiles:insertAttribute name="body" />
				</div>
				<div class="ui-layout-south">
					<tiles:insertAttribute name="controls" />
				</div>
			</div>
		</div>
	</form:form>

	<div class="ui-layout-south">
		<div id="footer_msg" style="text-align: left;">${viewState.whereWeAre}</div>
		<div id="footer_copyrights">
			Copyright &copy; 2010-
			<script type="text/javascript"> var d = new Date();document.write(d.getFullYear());</script>
			&nbsp; IME,IIASA
		</div>
	</div>

</body>

</html>