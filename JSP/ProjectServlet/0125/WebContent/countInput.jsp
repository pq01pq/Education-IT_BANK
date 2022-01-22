<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>입력 받은 값까지 출력</h2>
	<form action="countOutput.jsp" method="post">
		<table border="1">
			<tr> <th>정수 입력</th> <td><input type="text" name="count"></td> </tr>
			<tr> <td colspan="2" align="center"> <input type="submit" value="전송"></td> </tr>
		</table>
	</form>
</body>
</html>