<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>회원가입</h2>
	<form action="memberCon.jsp" method="post">
		<label>아이디 </label><br> <input type="text" name="id"><br><br>
		<label>비밀번호 </label><br> <input type="password" name="password"><br><br>
		<label>비밀번호 확인 </label><br> <input type="password" name="confirmPassword"><br><br>
		<label>이름 </label><br> <input type="text" name="name"><br><br>
		<label>이메일 </label><br> <input type="text" name="email"><br><br>
		<label>전화번호 </label><br> <input type="text" name="phoneNumber"><br><br>
		<input type="submit" value="가입">
	</form>
</body>
</html>