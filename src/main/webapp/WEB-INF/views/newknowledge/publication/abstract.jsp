<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
	<div>
			<p>
				Abstract:
			</p>
			<form:textarea rows="3" style="width:600px;" id="abs" name="abs" path="abs" />
			<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "abs",
						widgetType : "dijit.form.Textarea",
						widgetAttrs : { promptMessage : "abstract", required : false }}));
             </script>
	</div>