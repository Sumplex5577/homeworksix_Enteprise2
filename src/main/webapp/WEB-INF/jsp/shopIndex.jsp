<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Shops control page</title>
</head>
<body>
<a href="http://localhost:9092">&#8592 Back</a>
<div align="center">
    <h1>${message}</h1>
    <h3>Click the following link to view all available shops:</h3>
    <a href="${pageContext.request.contextPath}/shops/all_shops">Shops List</a>
</div>
</body>
</html>