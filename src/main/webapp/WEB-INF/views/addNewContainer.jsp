<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>

<table style="top: 20px;">
    <h1>Assessment of the technical condition of the container</h1>
</table>
<table style="left: 20px;">
    <input type="checkbox" name="In"/>
    <input type="checkbox" name="Out"/>
    <input type="date" name="Date"/>

    <input type="checkbox" name="20dv"/>
    <input type="checkbox" name="40dv"/>
    <input type="checkbox" name="40hc"/>

    <input type="text" name="ContainerNo"/>
</table>

<table style="bottom: 20px; left: 20px;">
    <input type="text" name="OrderNo"/>
    <input type="text" name="Last Name"/>

    <input type="text" name="TruckNo"/>
    <input type="text" name="ChassisNo"/>
    <input type="text" name="WagonNo"/>

</table>
<form action="containerModel.jsp">
    <button type="submit" class="submit"> Submit</button>
    <button type="reset" class="clear">Clear</button>
</form>

<a href="/index.jsp">Back to home page</a>

</body>
</html>