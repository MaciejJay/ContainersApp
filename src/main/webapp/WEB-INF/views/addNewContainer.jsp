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
    <label>In: </label>
    <input type="checkbox" name="In"/>
    <label>Out: </label>
    <input type="checkbox" name="Out"/>
    <br/>
    <label>Date: </label>
    <input type="date" name="Date"/>
    <br/>
    <label>20dv: </label>
    <input type="checkbox" name="20dv"/>
    <label>40dv: </label>
    <input type="checkbox" name="40dv"/>
    <label>40hc: </label>
    <input type="checkbox" name="40hc"/>
    <br/>
    <label>Container Number: </label>
    <input type="text" name="ContainerNo"/>
    <br/>
</table>

<table style="bottom: 20px; left: 20px;">
    <label>Order Number: </label>
    <input type="text" name="OrderNo"/>
    <br/>
    <label>Last Name: </label>
    <input type="text" name="Last Name"/>
    <br/>
    <label>Truck Number: </label>
    <input type="text" name="TruckNo"/>
    <br/>
    <label>Chassis Number: </label>
    <input type="text" name="ChassisNo"/>
    <br/>
    <label>Waggon Number: </label>
    <input type="text" name="WaggonNo"/>
</table>
<form action="/container/add/model">
    <button type="submit" class="submit"> Submit</button>
    <button type="reset" class="clear">Clear</button>
</form>

<a href="/menu">Back to home page</a>

</body>
</html>