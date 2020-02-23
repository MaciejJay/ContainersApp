<html>
<head>
    <title>Welcome</title>

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
            bottom: 0;
            color: #f1f1f1;
            width: 100%;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="outside" style="
        position: relative;">

    <img src="/images/bg_con.jpg" alt="container" title="containerHome" style="
        height: 100%;
        width: 100%;
        left: 0;
        top: 0;
        z-index: auto;">

    <div class="inside"
         style="position: absolute;
         top: 280px;
         background-size: cover;
         -webkit-background-clip: text;
         padding-left: 20%;
         padding-right: 20%;"
    >

        <div>
            <a href="/login">
            <img border="0" alt="Login" src="/images/loginButton.png" width="250" height="130" style="float: left;">
            </a>
        </div>

        <div>
            <a href="/guest">
                <img border="0" alt="Login" src="/images/guestButton.png" width="250" height="130" style="float: right;">
            </a>
        </div>
    </div>
</div>
</body>
</html>