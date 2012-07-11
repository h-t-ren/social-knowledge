<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%@page contentType="text/html;charset=UTF-8"%>

<form:form>
<fieldset>
    	<legend>New ${publicationEntry.publicationType}</legend>
        <dl>
        	<dt><label for="title">title:</label></dt>
            <dd><input type="text" name="title" id="title" size="62" maxlength="128" /></dd>
        </dl>
        <dl>
        	<dt><label for="bibtex">bibtex:</label></dt>
            <dd><input type="text" name="bibtex" id="bibtex" size="32" maxlength="32" /></dd>
        </dl>
        
        <dl>
        	<dt><label for="author">author:</label></dt>
            <dd><c:forEach items="${publicationEntry.authorList}" var="selectedAuthor">
           <c:out value="${selectedAuthor.firstName}" />, <c:out value="${selectedAuthor.lastName}" />&nbsp;
            </c:forEach>
             <a id="addAuthors" href="${flowExecutionUrl}&_eventId=addAuthors" >Add authors</a>
            	<script type="text/javascript">
		           Spring.addDecoration(new Spring.AjaxEventDecoration({
			       elementId: "addAuthors",
			       event: "onclick",
			       popup:true,
			       params: {fragments: "body",mode:"embedded"}		
		           }));
	            </script>
            </dd>
        </dl>
        
         <dl>
        	<dt><label for="abs">abstract:</label></dt>
            <dd><textarea id="p_abs" name="p_abs"></textarea>
              <script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "p_abs",
						widgetType : "dijit.form.Textarea",
						widgetAttrs : { promptMessage : "abstract", required : false }}));
          </script>
            </dd>
        </dl>
        
        
        
        <c:forEach var="field" items="${publicationEntry.field}">
          <dl>
        	 <dt><label for="${field.name}">${field.name}:</label></dt>
             <dd><input type="text" name="${field.name}" id="${field.name}" size="32" maxlength="32" /></dd>
           </dl>
        </c:forEach>
          <dl>
        	 <dt></dt>
             <dd><button id="createPublication" type="submit" name="_eventId_createPublication">Create</button><button id="cancelPublication" type="submit" name="_eventId_cancelPublication">Cancel</button></dd>
           </dl>

    </fieldset>
    
</form:form>
