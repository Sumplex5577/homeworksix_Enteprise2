<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Online Shop control page</title>
    <style>
        ul {
            list-style-type: none;
            margin: 0;
            padding: 0;
        }
    </style>
</head>
<body>
<div align="center">
    <h1>${message}</h1>
    <h3>Choose options:</h3>
    <nav class="menu">
        <ul>
            <li><a href="${pageContext.request.contextPath}/persons">Persons control page</a></li>
            <li><a href="${pageContext.request.contextPath}/shops">Shops control page</a></li>
            <li><a href="${pageContext.request.contextPath}/products">Products control page</a></li>
            <li><a href="${pageContext.request.contextPath}/carts">Carts control page</a></li>
        </ul>
    </nav>
</div>
</body>
</html>