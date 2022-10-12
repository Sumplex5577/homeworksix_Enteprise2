<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8"/>
    <title>Persons control page</title>
</head>
<body>
<a href="http://localhost:9092">&#8592 Back</a>
<div align="center">
    <h1>${message}</h1>
    <h3>Click the following link to view all persons:</h3>
    <a href="${pageContext.request.contextPath}/persons/all_persons">Person List</a>
</div>
</body>
</html>