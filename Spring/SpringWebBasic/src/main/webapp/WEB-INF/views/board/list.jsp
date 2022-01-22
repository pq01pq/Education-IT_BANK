<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table border="1" style="width: 400px">
		<caption style="5"><font size="5"><b>게시글 목록</b></font></caption>
			<tr align="center"><th width="50px">번호</th> <th width="80px">작성자</th> <th>제목</th></tr>
		<c:forEach var="article" items="${articleList}" varStatus="number">
			<tr align="center"><td>${number.index + 1}</td>
				<td>${article.writer}</td>
				<td align="left">
					<a href="<c:url value='/board/content?boardNumber=${number.index + 1}'/>">${article.title}</a>
				</td></tr>
		</c:forEach>
	</table>
	
	<a href="<c:url value='/board/write'/>">글 쓰기</a>
</body>
</html>