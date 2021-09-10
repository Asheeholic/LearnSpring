<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Employees list</title>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
</head>
<body>
	<div class="container">
		<br>
		<h1> 사원 목록 </h1>
		<br>
		<button class="btn btn-primary" id="registerBtn">새로운 직원 입력</button>
		<br><br>
		<c:forEach items="${list }" var="employee">
			<a class="fs-3" href="get/${employee.employeeId}">${employee.lastName }</a><br>
			${employee.employeeId}, ${employee.email}, ${employee.jobId}, ${employee.salary}
			<hr>
		</c:forEach>	
	</div>

<script>
	$(function() {
		$("#registerBtn").on('click', function() {
			window.location.href = "register";
		})
	})
</script>
</body>
</html>