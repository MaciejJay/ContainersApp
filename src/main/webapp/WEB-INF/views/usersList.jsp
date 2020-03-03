<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01
Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>User Manager</title>
</head>
<body>
<div align="center">
    <h2>User Manager</h2>
    <form method="get" action="search">
        <input type="text" name="keyword" /> &nbsp;
        <input type="submit" value="Search" />
    </form>
    <h3><a href="/users/add">New Users</a></h3>
    <table border="1" cellpadding="5">
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
                    <a href="/edit?id=${users.username}">Edit</a>
                    &nbsp;&nbsp;&nbsp;
                    <a href="/delete?id=${users.username}">Delete</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>