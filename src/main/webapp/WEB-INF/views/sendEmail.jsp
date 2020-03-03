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
         style="position: absolute;
         top: 10%;
         background-size: cover;
         -webkit-background-clip: text;
         padding-right: 20%;">

        <div class="form" style="position: absolute;
            top: 20%;
            left: 30%;">
            <form class="form" method="get" action="mailto:" enctype="text/plain">
                <center>
                    <label for="email">Email</label>
                    <input type="email" id="email" name="Email" placeholder="Your email..">
                    <p>
                        <label for="fname">First Name</label>
                        <input type="text" id="fname" name="firstname" placeholder="Your name..">

                        <label for="lname">Last Name</label>
                        <input type="text" id="lname" name="lastname" placeholder="Your last name..">
                    </p>
                    <div>
                        <label for="subject">Subject</label>
                        <input type="text" id="subject" name="subject" placeholder="Subject.."/>
                    </div>

                    <label for="message"></label>
                    <textarea id="message" name="message" placeholder="Write something.." style="height:200px;
            width: 100%;
            padding: 12px;
            border: 1px solid;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;"></textarea>

                    <br/>
                    <input type="submit" value="Send">
                    <input type="reset" value="Clear">
                </center>
            </form>
        </div>
    </div>
</div>
</body>
</html>