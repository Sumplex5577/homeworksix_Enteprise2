<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="ISO-8859-1">
    <title>Updating Success</title>
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
    <h2>Person Phone Number is updated!</h2>
    <span>ID:</span><span>${person.id}</span><br/>
    <span>Phone number:</span><span>${person.phoneNumber}</span><br/>
</div>
<br>
<a href="${pageContext.request.contextPath}/persons/all_persons">Back to all persons</a>
</body>
</html>
