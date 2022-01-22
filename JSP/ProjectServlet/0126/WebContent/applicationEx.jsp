<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String info = application.getServerInfo();
int major = application.getMajorVersion();
int minor = application.getMinorVersion();
String path = application.getRealPath("/");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>웹 컨테이너 정보</h2>
	웹 컨테이너 이름 : <%= info %><br>
	서블릿 버전 : <%= major %>.<%= minor %><br>
	홈 디렉터리 : <%= path %><br>
</body>
</html>