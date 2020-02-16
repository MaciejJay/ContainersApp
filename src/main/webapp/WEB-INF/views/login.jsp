<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>

<table>
    <form action="/containerPage">
        <input type="text" placeholder="Username" name="login" required>
        <p style="color: red;">
        </p>
        <input type="password" placeholder="Password" name="psw" required>
        <p style="color: red;">
        </p>
        <button type="submit">Login</button>
    </form>
</table>

<a href="/index">Back to home page</a>

</body>
</html>