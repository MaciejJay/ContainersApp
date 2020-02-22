<html>
<head>
    <title>Welcome</title>

    <style>
        * {
            box-sizing: border-box;
        }

        body {
            font-family: Arial;
            font-size: 17px;
        }

        .outside {
            position: relative;
            margin: 0 auto;
        }

        .outside img {
            vertical-align: middle;
        }

        .outside .inside {
            position: absolute;
            bottom: 0;
            background: rgb(0, 0, 0);
            background: rgba(0, 0, 0, 0.5);
            color: #f1f1f1;
            width: 100%;
            padding: 20px;
        }
    </style>
</head>
<body>
<div class="outside" style="
        position: relative;">

    <img src="/images/containerhome.jpg" alt="container"  title="containerHome" style="
        height: 100%;
        width: 100%;
        left: 0;
        top: 0;
        z-index: 1;">

    <div class="inside" style="position: absolute;
         top: 20px;
         background-size: cover;
         background-color: black;
         -webkit-background-clip: text;
         padding-left: 20px;
         padding-right: 20px;">
    </div>

    <h1>Welcome on our site</h1>

    <div>
        <form action="/login" style="background-size: cover;
        float: left;">
            <button type="submit" class="login">Login</button>
        </form>
    </div>

    <div>
        <form action="/guest" style="background-size: cover; float: right;">
            <button type="submit" class="guest">Guest</button>
        </form>
    </div>
</div>
</body>
</html>