<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Find container</title>
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
                <c:forEach var="Container" items="${containerNo}">
                <table>
                    <h3>Your container : </h3>
                    <td>${Container.containerNo}
                </table>
                </c:forEach>
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