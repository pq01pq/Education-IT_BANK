<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>시험 점수 등록</h2>
	
	<form action="<c:url value='/score/register'/>" method="post">
		<p>
			# 이름 : <input type="text" name="stuName"><br>
			# 국어 : <input type="text" name="kor"><br>
			# 수학 : <input type="text" name="math"><br>
			# 영어 : <input type="text" name="eng"><br>
			<input type="submit" value="확인">
		</p>
	</form>
</body>
</html>