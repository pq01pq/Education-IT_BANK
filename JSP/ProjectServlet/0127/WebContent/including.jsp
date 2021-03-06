<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
	String subject = "JSP";
	Date today = new Date();
	SimpleDateFormat df = new SimpleDateFormat("yyyy년 mm월 dd일");
	String schedule = df.format(today);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h3>before include</h3>
	<hr>
	<jsp:include page="included.jsp" flush="false">
		<jsp:param value="<%= subject %>" name="subject"/>
		<jsp:param value="<%= schedule %>" name="schedule"/>
	</jsp:include>
	<!-- 다른 페이지로 제어정보를 모두 넘긴 후 다시 돌아옴 -->
	<!-- flush : 제어를 이동할 때 현재 버퍼의 내용을 클라이언트에게 보낼 것인가를 결정. 기본값은 false -->
	<hr>
	<h3>after include</h3>
</body>
</html>