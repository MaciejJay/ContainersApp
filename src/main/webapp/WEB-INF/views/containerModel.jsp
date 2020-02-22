<%@ page session="false" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html lang="en">
<body>

<table style="top: 20px;">
    <h1>Container model</h1>
</table>
<table style="top: 20px; left: 20px;">
    <input type="checkbox" name="Bent"/>
    <input type="checkbox" name="Broken"/>
    <input type="checkbox" name="Cracked"/>
    <input type="checkbox" name="Hole"/>
    <input type="checkbox" name="Missing"/>
    <input type="checkbox" name="Bruise"/>
    <input type="checkbox" name="Cut"/>
    <input type="checkbox" name="Dent"/>
    <input type="checkbox" name="Loose"/>
    <input type="checkbox" name="Rusty"/>
</table>

<table>
    <textarea id="message" name="message" placeholder="Description..." style="height:200px;
            width: 100%;
            padding: 12px;
            border: 1px solid;
            border-radius: 4px;
            box-sizing: border-box;
            margin-top: 6px;
            margin-bottom: 16px;
            resize: vertical;"></textarea>
</table>

<form action="">
    <button type="submit" class="submit">Save to db</button>
    <button type="submit" class="clear">Save and print</button>
</form>

<a href="/menu">Back to home page</a>

</body>
</html>