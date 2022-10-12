<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Products List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/products">&#8592 Back</a>
<h1 align="center">Products List</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Shop ID</th>
        </tr>
        <c:forEach  items="${all}" var ="product">
            <tr>
                <td>${product.id}</td>
                <td>${product.name}</td>
                <td>${product.price}</td>
                <td>${product.shopId}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<h2>Options:</h2>
<a href="${pageContext.request.contextPath}/products/add_product">Add new product</a><br>
<a href="${pageContext.request.contextPath}/products/remove_product">Remove product</a><br>
<a href="${pageContext.request.contextPath}/products/update_name">Update name</a><br>
<a href="${pageContext.request.contextPath}/products/update_price">Update price</a><br>
</body>

</html>