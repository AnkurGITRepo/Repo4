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


</head>
<body>

	<h1>Dashboard</h1>
	<a href="loadForm">Register Employee</a>
	</br>
	</br>
	<a href="getAll">All Employee</a>
	</br>
	</br>
	<a href="getEmails">All Employee Mails</a>
	</br>
	</br>
	<a href="getUserByID">Employee By ID</a>
	</br>
	</br>
	<a href="mailById">Mail By ID</a>
	</br>
	</br>

</body>
</html>