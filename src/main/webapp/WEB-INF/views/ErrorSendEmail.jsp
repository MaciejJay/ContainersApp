<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Send e-mail error</title>
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

    <
    <div class="inside"
         style="top: 20%;
            left: 30%;">

        <center>
            <h2>Sorry, the email was not sent because of the following error:</h2>
            <h3>${exception.message}</h3>
        </center>
    </div>
</div>
</body>
</html>
