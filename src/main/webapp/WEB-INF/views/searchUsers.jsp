<!DOCTYPE html>
<html lang="en">
<head>
    <title>Search users</title>
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

        <form method="get" action="/search">
            <input type="text" name="keyword"/> &nbsp;
            <input type="submit" value="Search"/>
        </form>

        <table border="1" cellpadding="5" style="background-color: white;">
            <tr>
                <th>Username</th>
                <th>First Name</th>
                <th>Last Name</th>
                <th>E-mail</th>
            </tr>
            <c:forEach items="${searchingUser}" var="users">
                <tr>
                    <td>${users.username}</td>
                    <td>${users.firstName}</td>
                    <td>${users.lastName}</td>
                    <td>${users.email}</td>
                </tr>
            </c:forEach>
        </table>
        <button onclick="window.location.href='/'" type="submit" class="pure-button pure-button-primary">
            Back to main page
        </button>
    </div>
</div>
</div>
</div>
</body>
</html>