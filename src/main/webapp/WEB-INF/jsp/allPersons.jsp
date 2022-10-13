<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE HTML>
<html>
<head>
    <meta charset="UTF-8" />
    <title>Person List</title>
</head>
<body>
<a href="${pageContext.request.contextPath}/persons">&#8592 Back</a>
<h1 align="center">Persons List</h1>

<div align="center">
    <table border="1">
        <tr>
            <th>ID</th>
            <th>First Name</th>
            <th>Last Name</th>
            <th>Phone Number</th>
        </tr>
        <c:forEach  items="${all}" var ="person">
            <tr>
                <td>${person.id}</td>
                <td>${person.firstName}</td>
                <td>${person.lastName}</td>
                <td>${person.phoneNumber}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<h2>Options:</h2>
<a href="${pageContext.request.contextPath}/persons/add_person">Add new person</a><br>
<a href="${pageContext.request.contextPath}/persons/remove_person">Remove person</a><br>
<a href="${pageContext.request.contextPath}/persons/update_first_name">Update first name</a><br>
<a href="${pageContext.request.contextPath}/persons/update_last_name">Update last name</a><br>
<a href="${pageContext.request.contextPath}/persons/update_phone_number">Update phone number</a><br>
</body>

</html>