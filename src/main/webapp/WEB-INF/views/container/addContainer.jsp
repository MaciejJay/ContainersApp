</html>
<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<head>

    <title>Add container</title>

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
<body>

<header>
    <!-- Content -->
    <div class="container">
        <div class="card border-0 shadow my-5">
            <div class="card-body p-5">

                <spring:url value="/containers/add" var="addContainerURL"/>
                <spring:url value="/containers/update" var="updateContainerURL"/>


                <div>
                    <table class="table table-bordered">
                        <h1>Container</h1>
                    </table>
                    <form:form method="POST" action="${update ? updateContainerURL : addContainerURL}"
                               modelAttribute="container">
                        <table class="table table-bordered">
                            <tr>
                                <td><form:label path="containerIdNumber">Container no</form:label></td>
                                <td><form:input path="containerIdNumber" required="required"
                                                value="${container.containerIdNumber}"/></td>
                            </tr>
                            <tr>
                                <td><form:label path="containerShipOwner">Container shipowner</form:label></td>
                                <td><form:input path="containerShipOwner" required="required"/></td>
                            </tr>
                        </table>
                        <table class="table table-bordered" >
                            <tr>
                                <td><form:label path="containerType">size</form:label></td>
                                <td>20dv<form:radiobutton path="containerType" value="20dv" required="required"/></td>
                                <td>40dv<form:radiobutton path="containerType" value="40dv" required="required"/></td>
                                <td>40hc<form:radiobutton path="containerType" value="40hc" required="required"/></td>
                            </tr>
                        </table>
                        <table class="table table-bordered">
                            <form:button class="btn btn-primary" name="submit" value="submit">Submit</form:button>
                            <button class="btn btn-light" type="reset">Clear</button>
                        </table>
                    </form:form>
                    <a href="/menu">Back to home page</a>
                    <a href="/containers/">Back to containers page</a>
                </div>
            </div>
        </div>
    </div>
</header>
</body>
</html>