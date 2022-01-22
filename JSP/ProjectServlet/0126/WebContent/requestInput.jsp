<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request 예제</h2>
	<form action="requestOutput.jsp" method="post">
		<label>이름 : </label><input type="text" name="name"><br>
		<label>나이 : </label><input type="text" name="age"><br>
		<label>성별 : </label>
		남자<input type="radio" name="gender" value="male">
		여자<input type="radio" name="gender" value="female"><br>
		<label>취미 : </label>
		<select name="hobby">
			<option>오픈워터수영</option>
			<option>헬기레펠</option>
			<option>철인삼종경기</option>
			<option>배낭여행</option>
		</select><br>
		<input type="submit" value="확인">
	</form>
</body>
</html>