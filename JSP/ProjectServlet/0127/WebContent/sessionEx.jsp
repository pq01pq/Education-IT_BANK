<%@page import="java.util.HashMap"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	HashMap<String, Object> ssMap = new HashMap<String, Object>();
	ssMap.put("id", "kks");
	ssMap.put("pw", "1234");
	session.setAttribute("info", ssMap);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>session el example</h2>
	표현식 : <%= (String)ssMap.get("id") %><br>
	el : ${ info.pw }<br>
	el : ${ info['pw'] }
	<!-- el에서 문자열은 작은따옴표로 구분 -->
	<!-- pw는 매개변수가 아니라 문자열이기 때문에 info[pw]로 쓸 수 없음 -->
</body>
</html>