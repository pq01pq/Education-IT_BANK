<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<Integer> list = new ArrayList<Integer>();
	for(int i=0; i<=10; i++){
		list.add(i);
	}
	request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>request el example</h2>
	<p>
		표현식 : <%= ((ArrayList) request.getAttribute("list")).get(0) %><br>
		el : ${ list[1] }
		
	</p>
	<p>
	<%	for(int i=0; i<list.size(); i++){
			pageContext.setAttribute("num", i); %>
			<!-- el은 지역변수에 접근하지 못하기 때문에 지역변수 i를 매개변수 num으로 저장 -->
			${ list[num] }<br>
	<%	} %>
	</p>
</body>
</html>