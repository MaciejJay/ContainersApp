<html>
<head>
    <title>Send email</title>

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
            font-weight: bold;
            color: white;
            text-shadow: -1px 0 black, 0 1px black, 1px 0 black, 0 -1px black;
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
         style="top: 25%;
            left: 25%;">

        <form method="post" action="/sendMail" enctype="multipart/form-data">
            <table border="0" width="80%">

                <tr>
                    <td>Email To:</td>
                    <td><input type="email" name="emailTo" size="74"/></td>
                </tr>
                <tr>
                    <td>Subject:</td>
                    <td><input type="text" name="subject" size="74"/></td>
                </tr>
                <tr>
                    <td>Message:</td>
                    <td><textarea style="resize: none" class="textarea" cols="70" rows="15" name="message"></textarea></td>
                </tr>
                <tr>
                    <td>Add file:</td>
                    <td><input type="file" name="attachFile" size="74" /></td>
                </tr>
                <tr>
                    <td colspan="2" align="center">
                        <button class="pure-button" type="submit" value="submit">Send E-mail</button>
                        <button class="pure-button" type="reset">Clear</button>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
</body>
</html>