<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page errorPage="errorCon.jsp" %>	<!-- 컴파일되어야 에러를 전달함. 컴파일 에러는 전달 못함 -->
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>error example</h2>
	<%
		try {
			int c = 0/0;
		} catch(Exception e){
			throw e;
			//throw new Exception("0으로 나눌 수 없음"); 
		}
	%>
</body>
</html>