<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Manager</title>

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

        <h2>User Manager</h2>

        <form method="get" action="/search">
            <input type="text" name="keyword"/> &nbsp;
            <input type="submit" value="Search"/>
        </form>
        <h3><a href="/new">New Users</a></h3>
        <table border="1" cellpadding="5" style="background-color: white;">
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-mail</th>
            </tr>
            <c:forEach items="${listUsers}" var="users">
                <tr>
                    <td>${users.username}</td>
                    <td>${users.firstName}</td>
                    <td>${users.lastName}</td>
                    <td>${users.email}</td>
                    <td>
                        <a href="/update/${users.username}">Edit</a>
                        &nbsp;&nbsp;&nbsp;
                        <a href="/delete/${users.username}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
        <button onclick="window.location.href='/'" type="submit" class="pure-button pure-button-primary">
            Back to main page
        </button>
    </div>
</div>
</div>
</body>
</html>