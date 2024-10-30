<!DOCTYPE html>
<html>
<head>
    <title>Item Details</title>
</head>
<body>
<h2>${item.name}</h2>
<p>Price: ${item.price}</p>
<p>Category: ${item.category.name}</p>
<h3>Comments</h3>
<ul>
    <c:forEach items="${item.comments}" var="comment">
        <li>${comment.content} by ${comment.author.fullName.getFullName()}</li>
    </c:forEach>
</ul>
<h3>Ratings</h3>
<p>Average Rating: ${item.averageRating}</p>
</body>
</html>