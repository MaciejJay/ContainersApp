<html>
<head>
    <title>Login</title>

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
         top: 30%;
         background-size: cover;
         -webkit-background-clip: text;
         padding-right: 20%;"
    >

        <div class="background" style="position: relative;
        background-color: azure;
        left: 50%;
        border-radius: 5px;
        width: 250px;
        height: 250px;">

            <div class="form" style="position: absolute;
            top: 20%;
            left: 20%;
            ">
                <table>
                    <form action="/menu" style="" class="pure-form">
                        <input type="text" placeholder="Username" name="login" required>
                        <p></p>
                        <input type="password" placeholder="Password" name="psw" required>
                        <p></p>
                        <button type="submit" class="pure-button pure-button-primary">Sign in
                        </button>
                    </form>
                </table>
                <br/>
                <button onclick="window.location.href='/'" type="submit" class="pure-button pure-button-primary">
                    Back to main page
                </button>
            </div>
        </div>
    </div>
</div>
</body>
</html>