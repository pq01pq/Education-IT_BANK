<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%!
	private String name = "김강사";
	private int age = 28;
	int kor = 90, eng= 95, math=79;
	
	public int getAge(){
		return age;
	}
	
	public String getName(){
		return name;
	}
	
	public String getMessage(){
		String message = name + "와 함께하는 세상은 아름답다.";
		
		return message;
	}
%>

이름 : <%= getName()%> <br>
나이 : <%= getAge() %>살 <br>

<%
int sum = kor + eng + math;
double avg = sum / 3.0;
%>

점수 : <%= avg %> <br>
메세지 : <%= getMessage() %>
</body>
</html>