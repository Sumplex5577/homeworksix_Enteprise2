<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Carts List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/carts">&#8592 Back</a>
<h1 align="center">Carts List</h1>
<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>Amount of products</th>
            <th>Sum</th>
            <th>Person ID</th>
            <th>Details</th>
            <th>Remove all products</th>
        </tr>
        <c:forEach  items="${all}" var ="cart">
            <tr>
                <td>${cart.id}</td>
                <td>${cart.amountOfProducts}</td>
                <td>${cart.sum}</td>
                <td>${cart.person.getId()}</td>
                <td><button><a href="${pageContext.request.contextPath}/carts/get_cart?id=${cart.id}">Details </a></button></td>
                <td><button><a href="${pageContext.request.contextPath}/carts/remove_all?id=${cart.id}">Remove all products </a></button></td>
            </tr>
        </c:forEach>
    </table>
</div>
<h2>Options:</h2>
<a href="${pageContext.request.contextPath}/carts/add_cart">Add new cart</a><br>
<a href="${pageContext.request.contextPath}/carts/remove_cart">Delete cart</a><br>
<a href="${pageContext.request.contextPath}/carts/add_product">Add product</a><br>
<a href="${pageContext.request.contextPath}/carts/remove_product">Remove product</a><br>
</body>
</html>