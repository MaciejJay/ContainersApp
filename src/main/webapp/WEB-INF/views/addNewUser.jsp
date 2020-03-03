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
<div class="outside">

    <img src="/images/bg_con.jpg" alt="container" title="containerHome" style="
        height: 100%;
        width: 100%;">

    <div class="inside"
         style="position: absolute;
         top: 10%;
         background-size: cover;
         -webkit-background-clip: text;
         padding-right: 20%;">

        <div class="background" style="position: relative;
        background-size: cover;
        left: 50%;
        border-radius: 5px;
        width: 250px;
        height: 250px;">

            <div class="form" style="position: absolute;
            top: 20%;
            left: 30%;">
                <form action="/users/add/save" method="post">
                    <table>
                        <h2>New User</h2>
                        <tr>
                            <td>Username: </td>
                            <td><form:input path="username" /></td>
                        </tr>
                        <tr>
                            <td>First Name: </td>
                            <td><form:input path="firstName" /></td>
                        </tr>
                        <tr>
                            <td>Last Name: </td>
                            <td><form:input path="lastName" /></td>
                        </tr>
                        <tr>
                            <td>Email: </td>
                            <td><form:input path="email" /></td>
                        </tr>
                        <tr>
                            <td>Password: </td>
                            <td><form:input path="password" /></td>
                        </tr>
                        <tr>
                            <td colspan="2"><input type="submit" value="Save"></td>
                        </tr>
                    </table>
                    <button onclick="window.location.href='/'" type="submit" class="pure-button pure-button-primary">
                        Back to main page
                    </button>
                    </table>
                </form>
            </div>
        </div>
    </div>
</div>
</body>
</html>