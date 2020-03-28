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
            top: 10%;
            background: darkgrey;
            background-size: cover;
            -webkit-background-clip: text;
            padding-left: 20%;
            padding-right: 20%;
        }

        .pure-table {
            background: darkgrey;
        }
    </style>
</head>
<body>

<div class="outside">
    <img src="/images/bg_con.jpg" alt="container" title="containerHome" style="
        height: 100%;
        width: 100%;">
    <div class="inside">
        <h1>All rapports from: ${container.containerIdNumber}</h1>
        <p>id: <c:out value="${container.containerIdNumber}"/></p>
        <p>shipowner: <c:out value="${container.containerShipOwner}"/></p>
        <p>type: <c:out value="${container.containerType}"/></p>

        <table class="pure-table">
            <tr>
                <form>
                    <button class="pure-button" type="submit"
                            formaction="/rapports/add/${container.containerIdNumber}">Add raport
                    </button>
                </form>
            </tr>
        </table>

        <table class="pure-table">
            <thead>
            <tr>
                <th>#</th>
                <th>Date of create</th>
                <th>User</th>
                <th>Add</th>
                <th>Update</th>
                <th>Delete</th>
            </tr>
            </thead>
            <tbody>
            <%int i = 0; %>
            <c:forEach items="${rapports}" var="raport">
                <tr>
                    <td><% out.print(++i); %></td>
                    <td>${raport.addDate}</td>
                    <td>${raport.user.firstName} ${raport.user.lastName}</td>
                    <td>
                        <form>
                            <button class="pure-button" type="submit"
                                    formaction="/damage/add/${raport.id}">Add damage
                            </button>
                        </form>
                    </td>
                    <td>
                        <form>
                            <button class="pure-button" type="submit"
                                    formaction="/rapports/${container.containerIdNumber}">Change
                            </button>
                        </form>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</div>
<a href="/menu">Back to home page</a>

</body>
</html>