<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
 <title>Insert title here</title>
</head>
<script>
	function goBack() {
		window.history.back()
	}
</script>
<head>
<title>ADD USER PAGE</title>
<style type="text/css">
.errors {
	color: red;
	font-family: serif;
	font-style: :italic;
}
</style>
</head>
<body>
	<form:form action="adduser" method="post" modelAttribute="users">
		 <form:hidden path="id" />
			  
 		Enter name:<form:input path="name" />
		<form:errors path="name" class="errors" />
		<br />
		 Enter password:<form:input path="password" />
		<form:errors path="password" class="errors" />
		<br />
		 Enter email:<form:input path="email" />
		<form:errors path="email" class="errors" />
		<br />
 		Enter phone:<form:input path="phone" />
		<form:errors path="phone" class="errors" />
		<br />
		Enter address:<form:input path="address" />
		<form:errors path="address" class="errors" />
		<br />
		Enter roles:<form:input path="roles" />
		<form:errors path="roles" class="errors" />
		<br />
		Enter active:<form:input path="active" />
		<form:errors path="active" class="errors" />
		<br />

		<input type="submit">

	</form:form>
	<button onclick="goBack()">Go Back</button>

</body>
</html>