<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/Layout/header.jsp" %>
	<form action="/Member/join.jsp" method="post">
		<table border="1" align="center">
			<tr><td colspan="2">정보입력</td></tr>
			<tr><th>아이디</th><td><input type="text" name="id"></td></tr>
			<tr><th>비밀번호</th><td><input type="password" name="password"></td></tr>
			<tr><th>이름</th><td><input type="text" name="name"></td></tr>
			<tr><th>이메일</th><td><input type="text" name="email"></td></tr>
			<tr><th>전화번호</th><td><input type="text" name="phone"></td></tr>
			<tr><td colspan="2" align="center">
				<input type="submit" value="입장">
				<input type="reset" value="초기화">
			</td></tr>
		</table>
	</form>
	<%@ include file="/Layout/footer.jsp" %>
</body>
</html>