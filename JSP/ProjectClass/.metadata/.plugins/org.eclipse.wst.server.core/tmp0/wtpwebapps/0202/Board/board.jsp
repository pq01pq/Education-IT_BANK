<%@page import="lab.sam.web.board.BoardBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="bbean" class="lab.sam.web.board.BoardBean"/>
<jsp:useBean id="bdao" class="lab.sam.web.board.BoardDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	String message = (String)request.getAttribute("message");
	String strPageNum = request.getParameter("pageNum");
	int pageNum = 1;
	if(strPageNum != null){
		pageNum = Integer.parseInt(strPageNum);
	}
	
	List<BoardBean> blist = bdao.getBoardList(pageNum);
	request.setAttribute("blist", blist);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/Layout/header.jsp" %>
	
	<table border="1" align="center">
		<caption><h2>게시판 목록</h2></caption>
		
		<tr style="text-align: center">
			<th style="width:50px">글번호</th>
			<th style="width:300px">글제목</th>
			<th style="width:100px">작성자</th>
			<th style="width:100px">작성일</th>
			<th style="width:50px">조회수</th>
		</tr>
		<c:forEach var="bbs" items="${blist}">
			<tr>
				<td align="center"><a href="/Board/read.jsp?lineNo=${bbs.lineNo}">${bbs.lineNo}</a></td>
				<td>${bbs.title}</td>
				<td align="center">${bbs.id}</td>
				<td align="center">${bbs.writeDate}</td>
				<td align="center">${bbs.readCount}</td>
			</tr>
		</c:forEach>
	</table>
	
	<table align="center">
		<tr>
			<td><input type="submit" value="이전"></td>
			<td><input type="submit" value="글쓰기"
					onclick="window.location='/Board/writeForm.jsp'"></td>
			<td><input type="submit" value="다음"></td>
		</tr>
	</table>
	
	<%@ include file="/Layout/footer.jsp" %>
</body>
</html>