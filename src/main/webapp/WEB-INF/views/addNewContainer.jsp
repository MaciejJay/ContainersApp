<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>

<table style="top: 20px;">
    <h1>Assessment of the technical condition of the container</h1>
</table>
<form action="/containers/add/model">
<table style="left: 20px;">
    <p>Gate: <label><input type="radio" name="Gate"> In</label>
             <label><input type="radio" name="Gate"> Out</label></p>
    <p>Date: <input type="date" name="Date"></p>
    <p>Size: <label><input type="radio" name="Size"> 20dv</label>
             <label><input type="radio" name="Size"> 40dv</label>
             <label><input type="radio" name="Size"> 40hc</label></p>
    <p>Container Number: <input type="text" name="ContainerNo" required="required"/> </p>
    <p>Order Number: <input type="text" name="OrderNo"/></p>
    <p>Last Name: <input type="text" name="Last Name"/></p>
    <p>Truck Number: <input type="text" name="TruckNo"/></p>
    <p>Chassis Number: <input type="text" name="ChassisNo"/></p>
    <p>Wagon Number: <input type="text" name="WagonNo"/></p>
</table>

    <button type="submit" class="submit"> Submit</button>
    <button type="reset" class="clear">Clear</button>
</form>
<br/>
<a href="/menu">Back to home page</a>

</body>
</html>