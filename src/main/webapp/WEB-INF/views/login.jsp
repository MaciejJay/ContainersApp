<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<html>
<head>
    <title>Login</title>

    <link rel="stylesheet" type="text/css" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script type="text/javascript" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap-show-password/1.0.3/bootstrap-show-password.min.js"></script>

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
         padding-right: 20%;">

        <div class="background" style="position: relative;
        background-size: cover;
        left: 50%;
        border-radius: 5px;
        width: 250px;
        height: 250px;">
            <div class="form" style="position: absolute;
            top: 20%;
            left: 20%;">
                <table>
                    <form action="/menu" style="" class="pure-form" method="post">
                        <input type="text" placeholder="Username" name="login" required>
                        <p></p>
                        <input type="password" id="password" name="password" class="form-control" data-toggle="password">
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
<script type="text/javascript">
    $("#password").password('toggle');
</script>
</body>
</html>