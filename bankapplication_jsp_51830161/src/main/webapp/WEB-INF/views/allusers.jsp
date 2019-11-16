<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>allusers page</title>
</head>
<script>
	function goBack(){
		window.history.back();
	}
</script>
<body>

	<h1>welcome ${user.name }</h1>
	<table border="2" align="center" width=25% bgcolor="skyblue">

		<thead>
			<tr>
				<th>id</th>
				<th>name</th>
				<th>email</th>
				<th>phone</th>
				<th>address</th>
				<th>roles</th>
				<th>active</th>
				<th>update</th>
				<th>delete</th>
				<th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${users}" var="user">
				<tr>
					<td>${user.id }</td>
					<td>${user.name}</td>
					<td>${user.email}</td>
					<td>${user.phone}</td>
					<td>${user.address}</td>
					<td>
					<c:forEach items="${user.roles}" var="roles">
					<c:out value="${roles}"></c:out>
					</c:forEach>
					</td>
					<td>${user.active}</td>
					<td><a href="update?id=${user.id }">update</a></td>
					<td><a href="delete?id=${user.id }">delete</a></td>


				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br />
	<a href="logout">logout</a>
	<br />
	<button onclick="goBack()">Go Back</button>
	<br />

</body>


</html>