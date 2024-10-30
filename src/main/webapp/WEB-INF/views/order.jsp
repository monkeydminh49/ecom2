<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Order Details</title>
</head>
<body>
<h2>Order Details</h2>
<p>Order ID: ${order.id}</p>
<p>Customer: ${order.customer.fullName.getFullName()}</p>
<p>Status: ${order.status}</p>

<h3>Items</h3>
<ul>
    <c:forEach items="${order.cart.items}" var="item">
        <li>${item.name} - ${item.price}</li>
    </c:forEach>
</ul>

<h3>Shipment</h3>
<p>Carrier: ${order.shipment.carrier}</p>
<p>Tracking Number: ${order.shipment.trackingNumber}</p>

<h3>Payment</h3>
<p>Method: ${order.payment.method}</p>
<p>Amount: ${order.payment.amount}</p>
</body>
</html>