<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!--
- /selectOne 요청을 통해 해당 학번을 가진 학생의 성적 정보를 조회하여
search-result.jsp에 해당 정보를 화면에 출력	
-->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>개별 점수 조회</h2>
	
	<form action="<c:url value='/score/selectOne'/>">
		<p>
			# 조회할 번호 : <input type="text" name="stuNum" size="5">
			<input type="submit" value="확인">
		</p>
	</form>
	
	<!-- 사용자가 입력한 번호의 정보가 없는 경우 "학번 정보가 없습니다." 메세지를 띄움 -->
	<p style="color:red;">${msg}</p>
</body>
</html>