<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Product to cart Form</title>
    <style type="text/css">
        label {
            display: inline-block;
            width: 200px;
            margin: 5px;
            text-align: left;
        }
        input[type=text], input[type=password], select {
            width: 200px;
        }
        button {
            padding: 10px;
            margin: 10px;
        }
    </style>
</head>
<body>
<div align="center">
    <h2>Add product by id:</h2>
    <form:form action="add_product" method="put" modelAttribute="product">
        <form:label path="cartId">Cart ID:</form:label>
        <form:input required="required" path="cartId"/><br/>
        <form:label path="id">Product ID:</form:label>
        <form:input required="required" path="id"/><br/>
        <form:button>Add</form:button>
    </form:form>
</div>
</body>
</html>