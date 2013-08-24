<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title></title>
</head>

<body>

<g:if test="${params.error}">
    <h1 style="color: #f00">Nooo...</h1>
</g:if>

<g:if test="${params.loggedOut}">
    <h1 style="color: #0f0">Bye bye.</h1>
</g:if>

<form name="f" action="${request.contextPath}/j_spring_security_check" method="POST">
    <p>
        <label>Username: <input type='text' name='j_username'
                                value="dan"/></label>
    </p>

    <p>
        <label>Password: <input type='password' name='j_password'
                                value="password"/></label>
    </p>

    <p>
        <input name="login" value="Login" type="submit"/>
    </p>
</form>

</body>
</html>