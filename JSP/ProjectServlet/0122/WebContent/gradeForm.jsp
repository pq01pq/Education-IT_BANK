<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="gradeResult.jsp" method="post">
		<label>이름 </label> <input type="text" name="name"> <br>
		<label>Java </label> <input type="text" name="java"> <br>
		<label>JSP </label> <input type="text" name="jsp"> <br>
		<label>Spring </label> <input type="text" name="spring"> <br>
		
		<input type="submit" value="확인">
		<input type="reset" value="취소">
	</form>
</body>
</html>