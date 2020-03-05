</html>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="https://unpkg.com/purecss@1.0.1/build/pure-min.css"
          integrity="sha384-oAOxQR6DkCoMliIh8yFnu25d7Eq/PHS21PClpwjOTeU2jRSq11vu66rf90/cZr47" crossorigin="anonymous">
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
            top: 30%;
            background: darkgrey;
            background-size: cover;
            -webkit-background-clip: text;
            padding-left: 20%;
            padding-right: 20%;
        }

        .pure-table {
            background: darkgrey;
        }

        .pure-input {
            font-family: Arial, serif;
            font-size: 17px;
            font-weight: bold;
            color: black;
        }

    </style>
</head>
<body>


<spring:url value="/containers/add" var="addContainerURL"/>
<spring:url value="/containers/update" var="updateContainerURL"/>
<div class="outside">
    <img src="/images/bg_con.jpg" alt="container" title="containerHome" style="
        height: 100%;
        width: 100%;">


    <div class="inside">
        <table class="pure-table" style="top: 20px;">
            <h1>Container</h1>
        </table>
        <form:form method="POST" action="${update ? updateContainerURL : addContainerURL}" modelAttribute="container">
            <table class="pure-table">
                <tr>
                    <td><form:label path="containerIdNumber">containerIdNumber</form:label></td>
                    <td><form:input path="containerIdNumber" required="required"
                                    value="${container.containerIdNumber}"/></td>
                </tr>
                <tr>
                    <td><form:label path="containerShipOwner">containerShipOwner</form:label></td>
                    <td><form:input path="containerShipOwner" required="required"/></td>
                </tr>
            </table>
            <table class="pure-table" style="align-content: flex-end">
                <tr>
                    <td><form:label path="containerType">size</form:label></td>
                    <td>20dv<form:radiobutton path="containerType" value="20dv" required="required"/></td>
                    <td>40dv<form:radiobutton path="containerType" value="40dv" required="required"/></td>
                    <td>40hc<form:radiobutton path="containerType" value="40hc" required="required"/></td>
                </tr>
            </table>
            <table class="pure-table">
                <form:button class="pure-button" name="submit" value="submit">Submit</form:button>
                <button class="pure-button" type="reset">Clear</button>
            </table>
        </form:form>
        <a href="/menu">Back to home page</a>
        <a href="/containers/">Back to containers page</a>
    </div>

</div>
</body>
</html>