<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Send e-mail result</title>
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

    <img src="/images/bg_con.jpg" style="
        height: 100%;
        width: 100%;">

    <div class="inside"
         style="top: 20px;
            left: 20px;">
            <table>
                <td><h2>Thank you, your email has been sent.</h2></td>
            </table>
        </div>
    </div>
</div>
</body>
</html>
