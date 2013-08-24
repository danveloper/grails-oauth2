<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Oauth2 Confirmation</title>
</head>

<body>

<h2>Please Confirm</h2>

<p>You hereby authorize <strong>${client.clientId}</strong> to access your protected resources.</p>

<form id="confirmationForm" name="confirmationForm" action="${request.contextPath}/oauth/authorize" method="post">
    <input name="user_oauth_approval" value="true" type="hidden"/>
    <label><input name="authorize" value="Authorize" type="submit"></label>
</form>
<form id="denialForm" name="denialForm" action="${request.contextPath}/oauth/authorize" method="post">
    <input name="user_oauth_approval" value="false" type="hidden"/>
    <label><input name="deny" value="Deny" type="submit"></label>
</form>
</body>
</html>