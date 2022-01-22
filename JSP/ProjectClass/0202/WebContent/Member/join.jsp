<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	request.setCharacterEncoding("utf-8");
%>
<jsp:useBean id="bean" class="lab.sam.web.member.MemberBean"/>
<jsp:useBean id="dao" class="lab.sam.web.member.MemberDAO"/>
<jsp:setProperty name="bean" property="*"/>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
	String name="";
	String msg = "";
	boolean result = dao.join(bean);
	if(result) {
		name = bean.getName();
		msg = name + "님 가입되셨습니다.";
	} else {
		msg = "다시 가입해주세요.";
	}
	
	request.setAttribute("message", msg);
	pageContext.forward("/index.jsp?pageId=join");
%>
</body>
</html>