<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>정보 입력</h2>
	<form action="kksCon.jsp" method="post">
		<table border="1">
			<tr> <th>이름</th> <td><input type="text" name="name"></td> </tr>
			<tr> <th>나이</th> <td><input type="text" name="age"></td> </tr>
			<tr> <td colspan="2"><input type="submit" value="보내기"></td> </tr>
		</table>
	</form>
</body>
</html>