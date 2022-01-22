<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String javaStr = "java";
	pageContext.setAttribute("jsp", "jsp는 재미있다");
	pageContext.setAttribute("real", "레알??");
	
	pageContext.setAttribute("fruit", new String[] {"사과", "배", "딸기", "감"});
	String[] fruits = (String[]) pageContext.getAttribute("fruit");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>el example</h2>
	<%= pageContext.getRequest().getProtocol() %><br>
	${ pageContext.request.protocol }
	<!-- 함수형태의 명령어 실행은 못하지만 같은이름의 getter 함수를 실행시킴 -->
	<p>
		표현식 : <%=javaStr %><br>
		el : ${ javaStr }	<!-- 지역변수 출력 못함 -->
	</p>
	<p>
		표현식 : <%=pageContext.getAttribute("jsp") %><br>
		el : ${ real }
	</p>
	<p>
		표현식 : <%= ((String[])(pageContext.getAttribute("fruit")))[0] %><br>
		표현식 : <%= fruits[1] %><br>
		el : ${ fruit[2] }
	</p>
</body>
</html>