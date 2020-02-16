<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>
<spring:url value="/user" var="addUserUrl"/>
<spring:url value="/user/update" var="updateUserUrl"/>

<form:form method="POST" action="${update ? updateUserUrl : addUserUrl}" modelAttribute="user">
    <table>
        <tr>
            <td><form:label path="username">Username</form:label></td>
            <td><form:input path="username" readonly="${update}"/></td>
        </tr>
        <tr>
            <td><form:label path="firstName">First name</form:label></td>
            <td><form:input path="firstName"/></td>
        </tr>
        <tr>
            <td><form:label path="lastName">Last name</form:label></td>
            <td><form:input path="lastName"/></td>
        </tr>
        <tr>
            <td><input type="submit" value=""/></td>
        </tr>
    </table>
</form:form>

<a href="/users">Back to home page</a>

</body>
</html>