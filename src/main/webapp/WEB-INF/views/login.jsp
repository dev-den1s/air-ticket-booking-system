<!-- To use ExpressionsLanguage because i have bad version of jsp -->
<%@ page isELIgnored="false" %>

<!-- Add lib which contains basic tags for wild used tasks -->
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<html>
<head>
<title>LogIn</title>
</head>
<body>
<h2> <c:out value="${text}" /> </h2>
<form method="POST">
  Username: <input name="login" required >
  <br><br>
  Password: <input name="password" required>
  <br><br>
  <input type="submit" value="Log In">
</form>

<p><a href="http://www.webmasters.by/articles/html-coding/2478-custom-login-form.html">Dla nowoj formy</a></p>

</body>
</html>