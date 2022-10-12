<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Deleting Success</title>
    <style type="text/css">
        span {
            display: inline-block;
            width: 200px;
            text-align: left;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Cart is deleted!</h2>
    <span>ID:</span><span>${cart.id}</span><br/>
</div>
<br>
<a href="${pageContext.request.contextPath}/carts/all_carts">Back to all carts</a>
</body>
</html>
