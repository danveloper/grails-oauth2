<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="authz" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>Dashboard ==> <authz:authentication property="name"/></h1>

<a href="${request.contextPath}/oauth/authorize?client_id=oauth-consumer-app&response_type=code&redirect_uri=${request.contextPath}/app/doAuth">
    Click Here: Test Authorization Button
</a>

</body>
</html>