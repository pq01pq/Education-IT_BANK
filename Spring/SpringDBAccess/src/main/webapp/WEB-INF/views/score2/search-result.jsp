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
	<h2>${stu.stuName} 학생 성적 정보 조회</h2>
	<p>
		# 국어 : ${stu.kor}점<br>
		# 수학 : ${stu.math}점<br>
		# 영어 : ${stu.eng}점<br>
		# 총점 : ${stu.total}점<br>
		# 평균 : ${stu.average}점<br>
	</p>
	
	<a href="<c:url value='mybatis/score/list'/>">점수 전체 조회</a>
	<a href="<c:url value='mybatis/score/search'/>">점수 개별 조회</a>
</body>
</html>