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
         top: 40%;
         background-size: cover;
         -webkit-background-clip: text;
         padding-left: 20%;
         padding-right: 20%;"
    >

        <div>
            <a href="/login">
                <img border="0" alt="Login" src="/images/loginButton.png" width="25%" height="width*0.6"
                     style="float: left;">
            </a>
        </div>

        <div>
            <a href="/guest">
                <img border="0" alt="Login" src="/images/guestButton.png" width="25%" height="width*0.6"
                     style="float: right;">
            </a>
        </div>
    </div>
</div>
</body>
</html>