<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%-- jsp 주석 --%>
<%-- 자바 선언문
page : 생성되는 문서의 타입, 사용 언어, 객체 import, 세션 사용 여부 등
contentType = response.setContentType()으로 변환
pageEncoding = response.setCharacterEncoding()으로 변환
import : 다른 패키지에 있는 객체를 사용할 때
extends : 상속
session : 세션 사용 여부 -> session=false
buffer = 8kb : 출력 데이터의 크기를 지정할 수 있음
--%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%@ include file="top.jsp" %>	<%-- 파일 내용을 통째로 같다붙임 --%>
	<h2 align="center">body</h2>
	<%@ include file="bottom.jsp" %>
</body>
</html>