<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<script>
function goBack() {
  window.history.back()
} 
</script>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>ADD CUSTOMER PAGE</title>
<style type="text/css">
.errors{
	color:red;
	font-family: serif;
	font-style: :italic;
}
</style>
</head>
<body>
<form:form action="addcustomer" method="post" modelAttribute="customer">
 <form:hidden path="id"/>
 Enter name:<form:input path="name"/><form:errors path="name" class="errors"/><br/>
 Enter address:<form:input path="address"/><form:errors path="address" class="errors"/><br/>
 Enter number:<form:input path="phno"/><form:errors path="phno" class="errors"/><br/>
 Enter email:<form:input path="email"/><form:errors path="email" class="errors"/><br/>

<input type="submit">
</form:form>
<button onclick="goBack()">Go Back</button>
</body>
</html>