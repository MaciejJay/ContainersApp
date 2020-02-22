<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <title>Menu</title>
</head>

<body>
<h1>Menu</h1>

<ol>
    <li><a href="/addNewContainer">Add damage</a></li>
    <li><a href="/damageHistory">History of damage</a></li>
    <li><a href="/containerStatus">Container status</a></li>
    <li><a href="/changeContainerStatus">Change container status</a></li>
    <li><a href="/emailSend">Send email</a></li>
</ol>


<h3>Menu for admins</h3>
<h4>This will not be visible for users. I'll implement it later</h4>
<ol>
    <li><a href="/userSearch">Search user</a></li>
    <li><a href="/editUser">Edit user</a></li>
</ol>


</body>