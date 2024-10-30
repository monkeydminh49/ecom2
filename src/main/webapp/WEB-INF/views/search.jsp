<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Search Results</title>
</head>
<body>
<h2>Search Results</h2>
<form action="${pageContext.request.contextPath}/item/search" method="get">
    <input type="text" name="keyword" placeholder="Search items">
    <button type="submit">Search</button>
</form>
<ul>
    <c:forEach items="${items}" var="item">
        <li>${item.name} - ${item.price}
            <form action="${pageContext.request.contextPath}/cart/${customerId}/add" method="post">
                <input type="hidden" name="itemId" value="${item.id}">
                <button type="submit">Add to Cart</button>
            </form>
        </li>
    </c:forEach>
</ul>
</body>
</html>