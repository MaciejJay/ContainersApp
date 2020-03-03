<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
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
<div class="outside">

    <img src="/images/bg_con.jpg" alt="container" title="containerHome" style="
        height: 100%;
        width: 100%;">

    <div class="inside"
         align="center"
         style="top: 10%;">

        <form:form action="save" method="post" modelAttribute="newUsers">
            <table border="0" cellpadding="5">
                <h2>New User</h2>
                <tr>
                    <td>Username:</td>
                    <td><form:input path="username"/></td>
                </tr>
                <tr>
                    <td>First Name:</td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td>Last Name:</td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td>Password:</td>
                    <td><form:input path="password"/></td>
                </tr>
                <tr>
                    <td colspan="2"><input type="submit" value="Save"></td>
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