<!DOCTYPE html>
<html lang="en">
<head>
    <title>Send Email</title>
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
             style="top: 20%;
            left: 30%;">

        <form method="post" action="/sendEmail.do" enctype="multipart/form-data">
            <table border="0" width="80%">
                <tr>
                    <td>Email To:</td>
                    <td><input type="email" name="mailTo" size="65"/></td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input type="text" name="subject" size="65"/></td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td><textarea cols="50" rows="10" name="message"></textarea></td>
                </tr>
                <tr>
                    <td>Add file:</td>
                    <td><input type="file" name="attachFile" size="60"/></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <input type="submit" value="Send E-mail"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</div>
</body>
</html>