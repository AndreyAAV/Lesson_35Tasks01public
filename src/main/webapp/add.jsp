<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<html>
<head>
    <title>Add Purchase</title>
</head>
<body>
<form method="post" action="/AddPurchaseController">
    <label for="PurchaseName">Type Purchase Name: </label>
    <input type="text" name="PurchaseName" id="PurchaseName">
    <label for="PurchaseName">Type Purchase Price: </label>
    <input type="text" name="PurchasePrice" id="PurchasePrice">
    <label for="PurchaseName">Type Purchase Number: </label>
    <input type="text" name="PurchaseNumber" id="PurchaseNumber">
    <input type="submit">
</form>
</body>
</html>
