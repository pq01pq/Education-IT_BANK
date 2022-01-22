<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%!
	private String name = "김강사";
	private int age = 18;
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	이름 : <%= getName() %> <br>
	나이 : <%= getAge() %> <br>
	
	<% if(getAge() >= 20){ %>
		성인
	<% } else { %>
		미성년
	<% } %>
</body>
</html>