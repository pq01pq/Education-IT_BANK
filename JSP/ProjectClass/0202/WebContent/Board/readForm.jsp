<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/Layout/header.jsp" %>
	<table border="1" align="center">
		<tr>
			<th style="width:20%">제목</th>
			<td>${bbean.title}</td>
		</tr>
		<tr>
			<th style="width:20%">작성일</th>
			<td>${bbean.writeDate}</td>
		</tr>
		<tr>
			<th style="width:20%">작성자</th>
			<td>${bbean.id}</td>
		</tr>
		<tr>
			<th style="width:20%">조회수</th>
			<td>${bbean.readCount}</td>
		</tr>
		<tr>
			<td colspan="2" style="width:500px;height:200px">${bbean.content}</td>
		</tr>
	</table>
	
	<div align="center">
		<input type="button" value="목록으로" onclick="location.href='/Board/board.jsp'">
	</div>
	
	<%@ include file="/Layout/footer.jsp" %>
</body>
</html>