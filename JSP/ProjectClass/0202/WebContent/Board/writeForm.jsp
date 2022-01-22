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
	
	<form action="/Board/write.jsp" method="post">
		<input type="hidden" name="id" value="${sessionScope.sid}">
		<table border="1" align="center">
		<tr>
			<th width="60">제목</th><td><input type="text" name="title" size="50"></td>
		</tr>
		<tr>
			<td colspan="2">
			<textarea rows="15" cols="65" name="content"></textarea>
			</td>
		</tr>
		
		</table>
		<div align="center">
		<input type="submit" value="글쓰기">
		</div>
	
	</form>
	
	<%@ include file="/Layout/footer.jsp" %>

</body>
</html>