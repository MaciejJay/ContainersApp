<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <title>Menu</title>
</head>

<body>
<h1>Menu</h1>

<ol>
    <li><a href="/container/add">Add damage</a></li>
    <li><a href="/damages/history">History of damage</a></li>
    <li><a href="/container/status">Container status</a></li>
    <li><a href="/email/send">Send email</a></li>
</ol>


<h3>Menu for admins</h3>
<h4>This will not be visible for users. I'll implement it later</h4>
<ol>
    <li><a href="/users/search">Search user</a></li>
    <li><a href="/user/edit">Edit user</a></li>
</ol>


</body>