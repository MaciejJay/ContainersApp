<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>

<form:form method="POST" modelAttribute="user">
    <table>
        <form action="/container/find">
            <input type="text" placeholder="Container Number" name="containerNo" required>
            <p style="color: red;">
            </p>
            <input type="password" placeholder="PIN Number" name="NoPin" required>
            <p style="color: red;">
            </p>
            <button type="submit">Find Container</button>
        </form>
    </table>
</form:form>

<a href="/">Back to home page</a>

</body>
</html>