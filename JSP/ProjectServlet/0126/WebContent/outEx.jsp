<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
int bufferSize = out.getBufferSize();
int remainSize = out.getRemaining();
int usedSize = bufferSize - remainSize;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>출력 버퍼 정보</h2>
	버퍼 크기 : <%= bufferSize %> <br>
	사용중인 버퍼 : <%= usedSize %> <br>
	사용가능한 버퍼 : <%= remainSize %> <br>
</body>
</html>