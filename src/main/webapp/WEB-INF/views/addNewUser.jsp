<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="from" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page isELIgnored="false" %>
<%@ page session="false" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Exception</title>
    <style>
        * {
            box-sizing: border-box;
        }

        body, html {
            margin: 0;
        }

        body {
            font-family: Arial, serif;
            font-size: 17px;
            font-weight: bold;
            color: white;
            text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
        }

        .outside {
            position: relative;
        }

        .outside img {
            background-position: center;
            background-repeat: no-repeat;
            background-size: cover;
        }

        .inside {
            position: absolute;
            width: 100%;
        }

    </style>
</head>
<body>
<spring:url value="/users/add" var="addUserURL"/>
<spring:url value="/users/update" var="updateUserURL"/>

<div class="outside">
    <img src="/images/bg_con.jpg" style="
        height: 100%;
        width: 100%;">

    <div class="inside"
         align="center"
         style="top: 10%;">

        <form:form method="POST" action="${update ? updateUserURL : addUserURL}" modelAttribute="user">
            <table border="1" cellpadding="5" style="background-color: white;">
                <h2>New User</h2>

                <tr>
                    <td><from:label path="username">Username:</from:label></td>
                    <td><form:input path="username" required="required" value="${user.username}" readonly="${update}"/></td>
                </tr>
                <tr>
                    <td><form:label path="firstName">First Name:</form:label></td>
                    <td><form:input path="firstName" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="lastName">Last Name:</form:label></td>
                    <td><form:input path="lastName" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="email">Email:</form:label></td>
                    <td><form:input path="email" required="required"/></td>
                </tr>
                <tr>
                    <td><form:label path="password">Password:</form:label></td>
                    <td><form:input path="password" required="required"/></td>
                </tr>
                <tr>
                    <form:button class="pure-button" name="submit" value="submit">Submit</form:button>
                    <button class="pure-button" type="reset">Clear</button>
                </tr>
            </table>
        </form:form>
        <button onclick="window.location.href='/'" type="submit" class="pure-button pure-button-primary">
            Back to main page
        </button>
    </div>
</div>
</div>
</div>
</body>
</html>