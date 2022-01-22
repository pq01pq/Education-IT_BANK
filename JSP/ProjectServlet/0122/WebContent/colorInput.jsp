<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="colorOutput.jsp" method="post">
		<label>이름 </label> <input type="text" name="name"> <br>
		<label>색깔 </label>
		<select name="color">
			<option value="red">red</option>
			<option value="green">green</option>
			<option value="blue">blue</option>
			<option value="yellow">yellow</option>
		</select> <br>
		
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
</body>
</html>