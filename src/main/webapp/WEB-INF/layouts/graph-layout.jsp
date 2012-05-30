<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<html>
  <head>
    <link href="<c:url value="/resources/neo/css/global.css"/>" rel='stylesheet'>
    <script src='http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js'></script>
    <script src='http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.16/jquery-ui.min.js'></script>
    <script src="<c:url value="/resources/neo/js/ui.js"/>"></script>
    <script src="<c:url value="/resources/neo/js/processing.min.js"/>"></script>
    <title>Neovigator</title>
  </head>
  <body>
  
     <tiles:insertAttribute name="body" />
  </body>
</html>
  