<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Containers</title>

    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1, shrink-to-fit=no" name="viewport">

    <!-- Bootstrap CSS -->
    <link crossorigin="anonymous" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" rel="stylesheet">

    <!-- Custom CSS -->
    <spring:url value="/css/custom.css" var="springCss"/>
    <link href="${ springCss }" rel="stylesheet"/>

</head>

</head>
<body>

<header>
    <!-- Content -->
    <div class="container">
        <div class="card border-0 shadow my-5">
            <div class="card-body p-5">

                <div>
                    <nav class="navbar navbar-light bg-light justify-content-end">
                        <a class="navbar-brand col-sm-5 text-monospace">Containers</a>

                        <form class="form-inline">
                            <td>
                                <button class="btn btn-primary my-2 my-sm-2" type="submit" formaction="/containers">Show
                                    all
                                </button>
                            </td>
                        </form>

                        <form class="form-inline">
                            <td>
                                <button class="btn btn-primary" type="submit"
                                        formaction="/containers/add"
                                        name="add container">Add
                                </button>
                            </td>
                        </form>

                        <form action="${pageContext.request.contextPath}/containers/" class="form-inline">
                            <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search"
                                   name="containerNo">
                            <button class="btn btn-outline-success my-2 my-sm-0" type="submit">Search</button>
                        </form>
                    </nav>
                </div>

                <div>
                    <table class="table table-bordered">
                        <thead class="thead-dark">
                        <tr>
                            <th>#</th>
                            <th>Container Id Number</th>
                            <th>DELETE</th>
                            <th>UPDATE</th>
                            <th>add report</th>
                            <th>show all reports</th>
                        </tr>
                        </thead>
                        <tbody>
                        <%int i = 0; %>
                        <c:forEach items="${containerSet}" var="container">
                            <tr>
                                <td><% out.print(++i); %></td>
                                <td>${container.containerIdNumber}</td>
                                <td><a href="/containers/delete/${container.containerIdNumber}">Delete</a></td>
                                <td><a href="/containers/update/${container.containerIdNumber}">Update</a></td>
                                <td>
                                    <form>
                                        <button class="btn btn-primary" type="submit"
                                                formaction="/reports/form/${container.containerIdNumber}">
                                            Add raport
                                        </button>
                                    </form>
                                </td>
                                <td>
                                    <form>
                                        <button class="btn btn-primary" type="submit"
                                                formaction="/reports/${container.containerIdNumber}">
                                            Show all reports
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
    </div>
</header>
</body>
</html>