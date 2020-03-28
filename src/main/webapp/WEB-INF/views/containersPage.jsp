<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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

</head>
<body>
<div class="outside">
    <img src="/images/bg_con.jpg" alt="container" title="containerHome" style="
        height: 100%;
        width: 100%;">

    <div class="inside">
        <div>
            <table class="pure-table">
                <tr>
                    <td>
                        <form action="/containers">
                            <input class="pure-input" type="search" name="containerNo"/>
                            <input class="pure-button" type="submit" title="Search"/>
                        </form>
                    </td>
                    <td>
                        <form>
                            <button class="pure-button" type="submit" formaction="/containers">Show all containers
                            </button>
                        </form>
                    </td>
                    <td>
                        <form>
                            <button class="pure-button" type="submit" formaction="/containers/add"
                                    name="add container">Add container
                            </button>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
        <div>
            <table class="pure-table">
                <thead>
                <tr>
                    <th>#</th>
                    <th>Container Id Number</th>
                    <th>Excel</th>
                    <th>PDF</th>
                    <th>DELETE</th>
                    <th>UPDATE</th>
                    <th>add raport</th>
                    <th>show all rapports</th>
                </tr>
                </thead>
                <tbody>
                    <%int i = 0; %>
                    <c:forEach items="${containerSet}" var="container">
                        <tr>
                            <td><% out.print(++i); %></td>
                            <td>${container.containerIdNumber}</td>
                            <td><a href="/raport/xlsx/download">EXCEL</a></td>
                            <td><a href="/raport/pdf/download">PDF</a></td>
                            <td><a href="/containers/delete/${container.containerIdNumber}">Delete</a></td>
                            <td><a href="/containers/update/${container.containerIdNumber}">Update</a></td>
                            <td>
                                <form>
                                    <button class="pure-button" type="submit"
                                            formaction="/raport/${container.containerIdNumber}"
                                            name="add raport">Add raport
                                    </button>
                                </form>
                            </td>
                            <td>
                                <form>
                                    <button class="pure-button" type="submit"
                                            formaction="/rapports/${container.containerIdNumber}">
                                        Show all raport
                                    </button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </div>
</div>
</body>
</html>