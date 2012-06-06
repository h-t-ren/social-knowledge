<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>


<div id="ime_left_menu">
<ul id="ime_left_menu_list">

	<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=1"/>"
			class="ime_left_menu_sub_link">Article</a>
	</li>

	<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=2"/>"
			class="ime_left_menu_sub_link">Book</a>
			
	</li>
	
	<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=3"/>"
			class="ime_left_menu_sub_link">Booklet</a>
			
	</li>
	
	<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=4"/>"
			class="ime_left_menu_sub_link">Inbook</a>
			
	</li>
	
	<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=5"/>"
			class="ime_left_menu_sub_link">Incollection</a>
			
	</li>
	
	<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=6"/>"
			class="ime_left_menu_sub_link">Inproceedings</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=7"/>"
			class="ime_left_menu_sub_link">Manual</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=8"/>"
			class="ime_left_menu_sub_link">Masterthesis</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=9"/>"
			class="ime_left_menu_sub_link">Misc</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=10"/>"
			class="ime_left_menu_sub_link">Phdthesis</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=11"/>"
			class="ime_left_menu_sub_link">Proceeding</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=12"/>"
			class="ime_left_menu_sub_link">Techreport</a>
			
	</li>
		<li class="ime_left_menu_sub_item">
	<a href="<c:url value="/newknowledge/publicationForm?idPublicationType=13"/>"
			class="ime_left_menu_sub_link">Unpublished</a>
			
	</li>

	<li class="ime_left_menu_sub_item"><a 
		href="<c:url value="/newknowledge/bibTexForm" />"
		class="ime_left_menu_sub_link">Import BibTex</a></li>

	<li class="ime_left_menu_sub_item">
	<a  
			href="<c:url value="/newknowledge/authorForm"/>"
			class="ime_left_menu_sub_link">Author</a>
			
	</li>

	<li class="ime_left_menu_sub_item"><a 
	     href="<c:url value="/newknowledge/journalForm" />"
		class="ime_left_menu_sub_link">Journal</a></li>
	

</ul>




</div>