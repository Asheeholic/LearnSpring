<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/sample/ex05">
		<!-- 필드 이름을 맞춤.(list) -->
		<input name="list[0].name"><input name="list[0].age"><br>
		<input name="list[1].name"><input name="list[1].age"><br>
		<input name="list[2].name"><input name="list[2].age"><br>
		<button>입력</button>
	</form>
</body>
</html>