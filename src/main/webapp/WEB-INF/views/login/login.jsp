<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page
	import="org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>

<c:if test="${not empty param.login_error}">
	<div class="error">
		Your login attempt was not successful, try again.<br />
		<br /> Reason:
		<%= ((AuthenticationException) session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_EXCEPTION_KEY)).getMessage() %>
	</div>
</c:if>
<form id="loginform" name="f"
	action="<c:url value="/login/login/authenticate" />" method="post">
	<div align="center">
		<table style="width: 800px;">
			<tr>
				<td align="center">
					<fieldset class="login">
						<table>
							<tr>
								<th align="right"><font class="FieldText1">Nick-name:</font>
									<input value="hongtao" type="text" style="width: 12em"
									name="j_username" id="j_username"
									<c:if test="${not empty param.login_error}">value="<%= session.getAttribute(UsernamePasswordAuthenticationFilter.SPRING_SECURITY_LAST_USERNAME_KEY) %>"</c:if> />
									<script type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "j_username",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your username", required : true }}));
				</script> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="http://www.ime.iiasa.ac.at/users/reg/form.jsp?usr=MCA"
									target="_blank">New user of the IME applications</a></th>

							</tr>
							<tr>
								<th align="right"><font class="FieldText1">PIN:&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</font>
									<input value="hongtao" type="password" name="j_password"
									id="j_password" style="width: 12em" /> <script
										type="text/javascript">
					Spring.addDecoration(new Spring.ElementDecoration({
						elementId : "j_password",
						widgetType : "dijit.form.ValidationTextBox",
						widgetAttrs : { promptMessage : "Your password", required : true}}));
				</script> &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="http://www.ime.iiasa.ac.at/users/pin/remakeform.jsp?usr=MCA"
									target="_blank">Re-make my PIN</a>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<a
									href="http://www.ime.iiasa.ac.at/users/pin/changeform.jsp?usr=MCA"
									target="_blank">Change my PIN</a></th>
							</tr>
						</table>
						<button id="submit" type="submit">Login</button>
						<script type="text/javascript">
		    Spring.addDecoration(new Spring.ValidateAllDecoration({event : 'onclick', elementId : 'submit'}));
		</script>
					</fieldset>
				</td>
			</tr>

		</table>
	</div>
</form>
<div align="center">
	<table style="width: 800px;">
		<tr>
			<td align="left">Hints on the login procedure:</td>
		</tr>
		<tr>
			<td align="center">
				<div class="info">
Login to the IME Applications requires Nick-name and PIN-code.<br/>
A Nick-name can be used for more than one application.<br/><br/>

If you have not registered yet your Nick-name to the IME applications, then<br/>
please make your registration by following the "New user of the IME applications.<br/>
After completing the registration process you will receive information about<br/>
your PIN.<br/><br/>

The PIN-codes are generated and emailed automatically.<br/>
If you have forgotten your PIN, then please follow the link "Re-make my PIN".<br/>
You may also redefine your PIN by following the link "Change my PIN".<br/>

Please use the "Contact" link (available on all screen of the IME applications)<br/>
for reporting problems and questions.<br/></div>
			</td>
		</tr>

		<tr>
			<td align="left">Requirements for the web-browser:</td>
		</tr>
		<tr>

			<td align="center">
				<div class="info">This application requires a Web-browser with<br/>
					pop-up windows enabled at least for www.ime.iiasa.ac.at The<br/>
					application is tested to work correctly with the following<br/>
					browsers: - Firefox ver. 3 - MS Explorer ver. 6 - Safari - Opera<br/>

					The minimum screen resolution is: 1024 x 768</div>
			</td>
		</tr>
	</table>
</div>

