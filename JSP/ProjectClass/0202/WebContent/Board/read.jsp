<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<jsp:useBean id="bbean" class="lab.sam.web.board.BoardBean"/>
<jsp:useBean id="bdao" class="lab.sam.web.board.BoardDAO"/>
<%
	request.setCharacterEncoding("utf-8");
	String strLineNo = (String)request.getAttribute("lineNo");
	String msg = "페이지가 올바르지 않습니다.";
	String url = "/Board/board.jsp";
	
	String strPageNum = request.getParameter("pageNum");
	int lineNo = 0;
	
	if(strLineNo != null){
		lineNo = Integer.parseInt(strLineNo);
	}
	
	if(lineNo < 1){
		msg = "페이지가 올바르지 않습니다.";
	} else{
		bbean = bdao.getContent(lineNo);
		if(bbean != null){
			request.setAttribute("bbean", bbean);
			url = "/Board/readForm.jsp";
		}
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

</body>
</html>

<%
	request.setAttribute("message", msg);
	RequestDispatcher dispatcher = request.getRequestDispatcher(url);
	dispatcher.forward(request, response);
%>