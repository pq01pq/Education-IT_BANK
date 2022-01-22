<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	request.setCharacterEncoding("utf-8");
	String msg = "";
	String url = "/Board/board.jsp";
%>
<jsp:useBean id="bbean" class="lab.sam.web.board.BoardBean"/>
<jsp:useBean id="bdao" class="lab.sam.web.board.BoardDAO"/>
<jsp:setProperty name="bbean" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="/Layout/header.jsp" %>
	<c:choose>
		<c:when test="${empty sessionScope.sid}">
		<%	msg = "로그인 후에 사용 가능합니다.";
			url = "Member/loginForm.jsp?pageId=board";
		%>
		</c:when>
		<c:when test="${empty param.title or empty param.content}">
		<%	msg = "내용을 완성해주세요.";
			url = "/Board/writeForm.jsp";
		%>
		</c:when>
		<c:otherwise>
		<%
			boolean check = bdao.write(bbean);
			if(check){
				msg = "글쓰기를 완료했습니다.";
			} else{
				msg = "다시 작성해주세요.";
				url = "/Board/writeForm.jsp";
			}
		%>
		</c:otherwise>
	</c:choose>
	<%@ include file="/Layout/footer.jsp" %>
</body>
</html>

<%
	request.setAttribute("message", msg);
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
%>