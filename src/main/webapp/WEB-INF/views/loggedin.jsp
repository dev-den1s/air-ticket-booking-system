<!-- To use ExpressionsLanguage because i have bad version of jsp -->
<%@ page isELIgnored="false" %>

<!-- Add lib which contains basic tags for wild used tasks -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>Welcome</title>
</head>
<body>
<h2>Welcome, <c:out value="${client.name} ${client.surname}"/> </h2>
<p>Your email is <b> <c:out value="${client.email}"/> </b></p>
</body>
</html>