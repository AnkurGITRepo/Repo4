<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<style>
.error {
	color: #FF0000
}
</style>

<script src="https://code.jquery.com/jquery-1.12.4.js"></script>
<script
	src="https://cdn.jsdelivr.net/jquery.validation/1.16.0/jquery.validate.min.js"></script>
<script>
	$(function() {
		$('form[id="userRegForm"]').validate({
			rules : {
				eName : 'required',
				desg : 'required',
				date : 'required',
				mobile : 'required',
				gender : 'required',
				email : {
					required : true,
					email : true
				},
				mobile : {
					required : true,
					minlength : 8,
				}

			},
			messages : {
				eName : 'please enter eName',
				email : 'Please enter valid email',
				mobile : 'please enter phone number',
				gender : 'please enter phone gender',
				date : 'please enter date',
				desg : 'please enter phone desg',
			},
			submitHandler : function(form) {
				form.submit();
			}
		});
	});
</script>
</head>
<body>
	<font color='green'>${message}</font>

	<h2>Register Here</h2>
	<form:form action="addEmployee" method="POST" modelAttribute="employee"
		id="userRegForm">
		<table>
<%-- 			<tr>
				<td>Employee no</td>
				<td><form:input path="eNo" /></td>
			</tr>
 --%>			<tr>
				<td>Employee Name</td>
				<td><form:input path="eName" /></td>
			</tr>
			<tr>
				<td>desg</td>
				<td><form:label  path="desg" />
                  <form:radiobutton path = "desg" value = "BE" label = "BE" />
                  <form:radiobutton path = "desg" value = "ME" label = "ME" />
               </td>
			</tr>

			<tr>
				<td>Date</td>
				<td><form:input path="date" /></td>
			</tr>
			<tr>
				<td>Email</td>
				<td><form:input path="email" /></td>
			</tr>
			<tr>
				<td>Phone Number</td>
				<td><form:input path="mobile" /></td>
			</tr>
			<tr>
				<td>Gender</td>
				<td><form:select path="gender">
						<form:option value="NONE" label="Select" />
						<form:options items="${genderList}" />
						</form:select>
			</tr>
			<tr>

				<td><input type="submit" value="Register" /></td>
			</tr>
		</table>
	</form:form>

	<a href="getDashboard">Dashboard</a>

</body>
</html>