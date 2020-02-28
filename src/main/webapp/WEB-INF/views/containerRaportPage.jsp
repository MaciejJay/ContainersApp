<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>
<h1>Menu</h1>

<div style="left: 20px;">
    <h2><a href="/addNewContainer">Add new container</a></h2>
</div>
<div style="right: 20px">
    <spring:url value="/raport" var="generateRaportURL"/>

    <form:form method="POST" action="${generateRaportURL}" modelAttribute="workEstimateExcelDTO">
        <table>
            <td><form:label path="customer">Customer</form:label></td>
            <td><form:input path="customer"/></td>
                    <%-- TODO --%>
        </table>
    </form:form>


</div>

<a href="/menu">Back to home page</a>

</body>
</html>