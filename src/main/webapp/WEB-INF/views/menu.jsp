<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<head>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css"
          integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47" crossorigin="anonymous">
    <title>Menu</title>
    <style>
        .custom-restricted-width {
            display: inline-block;
        }
    </style>
</head>

<body>
<div class="pure-menu custom-restricted-width">
    <div class="menu-background">

    </div>
    <span class="pure-menu-heading">Menu</span>
    <ul>
        <li class="pure-menu-item"><a href="/container/add" class="pure-menu-link">Add damage</a></li>
        <li class="pure-menu-item"><a href="/damages/history" class="pure-menu-link">History of damage</a></li>
        <li class="pure-menu-item"><a href="/container/status" class="pure-menu-link">Container status</a></li>
        <li class="pure-menu-item"><a href="/email/send" class="pure-menu-link">Send email</a></li>
    </ul>

    <span class="pure-menu-heading">Menu for admins</span>
    <ul>
        <li class="pure-menu-item"><a href="/users/search" class="pure-menu-link">Search user</a></li>
        <li class="pure-menu-item"><a href="/user/edit" class="pure-menu-link">Edit user</a></li>
    </ul>
</div>

</body>