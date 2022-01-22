<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%!
	public class KimKangSa{
		int age;
		String name;
		
		public int getAge(){
			return age;
		}
		public String getName(){
			return name;
		}
		public void setAge(int age){
			this.age = age;
		}
		public void setName(String name){
			this.name = name;
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
	<h2>c:set 예제</h2>
	<c:set var="jsp" value="301호 김강사" />
	<c:set var="java" value="302호 김강오" />
	<c:set var="spring" value="303호 김강육" />
	<br>
	${jsp }<br>
<%	String subject = (String) pageContext.getAttribute("java"); %>
	<%= subject %><br>
	<%=  (String) pageContext.getAttribute("spring") %><br>
	<c:set var="jsp" value="타워팰리스 1102호 김강사" />	<!-- "jsp"를 새로운 값으로 대체 -->
	${jsp }
	
	<hr>
<%
	KimKangSa kks = new KimKangSa();
	kks.setAge(28);
	kks.setName("김강사");
	pageContext.setAttribute("ys", kks);
%>
	이름 : ${ ys.name }<br>
	나이 : ${ ys.age }살<br>
	
	<c:set target="${ ys }" property="name" value="김강오" />
	<c:set target="${ ys }" property="age" value="38" />
	
	이름 : ${ ys.name }<br>
	나이 : ${ ys.age }살<br>
</body>
</html>