<!DOCTYPE html>
<html>
<head>
    <title>Payment</title>
</head>
<body>
<h2>Payment</h2>
<form action="${pageContext.request.contextPath}/payment/process" method="post">
    <label for="method">Payment Method:</label>
    <select name="method" id="method">
        <option value="PayPal">PayPal</option>
        <option value="Card">Card</option>
        <option value="Cash">Cash</option>
    </select>
    <br><br>
    <label for="amount">Amount:</label>
    <input type="text" id="amount" name="amount" required>
    <br><br>
    <button type="submit">Process Payment</button>
</form>
</body>
</html>