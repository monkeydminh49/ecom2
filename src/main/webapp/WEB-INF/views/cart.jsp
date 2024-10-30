<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Shopping Cart</title>
</head>
<body>
<h2>Your Cart</h2>
<table>
    <thead>
    <tr>
        <th>Item</th>
        <th>Price</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${cart.items}" var="item">
        <tr>
            <td>${item.name}</td>
            <td>${item.price}</td>
            <td>
                <form action="${pageContext.request.contextPath}/cart/${cart.customer.id}/remove" method="post">
                    <input type="hidden" name="itemId" value="${item.id}">
                    <button type="submit">Remove</button>
                </form>
            </td>
        </tr>
    </c:forEach>
    </tbody>
</table>
<p>Total: ${cart.totalPrice}</p>
</body>
</html>