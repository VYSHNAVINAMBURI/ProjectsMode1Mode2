<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
function goBack() {
  window.history.back()
}
</script>
</head>
<body>
	<h1>welcome ${user.name }</h1>
	<table align="center" width=25% bgcolor="skyblue"></table>
	<br />
	<a href="logout">logout</a>
	<br />
	<br />
	<br />
	<div class="container">
		<div class="row">
			<div class="col-sm-6">

				<table class="table table-striped">

					<thead>
						<tr>
							<th>id</th>
							<th>name</th>
							<th>address</th>
							<th>phno</th>
							<th>email</th>
							<c:if test="${user.profile=='admin' }">
							<th>update</th>
							<th>delete</th>
							</c:if>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${customers}" var="customer">
							<tr>
								<td>${customer.id }</td>
								<td>${customer.name}</td>
								<td>${customer.address}</td>
								<td>${customer.phno}</td>
								<td>${customer.email}</td>
								
								<c:if test="${user.profile == 'admin'}">
									<td><a href="update?id=${customer.id }">update</a></td>
									<td><a href="delete?id=${customer.id }">delete</a></td>
								</c:if>
							</tr>
						</c:forEach>
						</tbody>

				</table>
			</div>
		</div>
	</div>

	<c:if test="${user.profile == 'admin' || user.profile == 'mgr'}">

		<a href="addcustomer">addcustomer</a>
		<button onclick="goBack()">Go Back</button>
	</c:if>
						
</body>
</html>