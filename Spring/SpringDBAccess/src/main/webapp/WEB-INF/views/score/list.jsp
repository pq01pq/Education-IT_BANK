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
	<h2>학생들의 전체 성적 조회</h2>
	<c:forEach var="stu" items="${sList}">
		<p>
			# 번호 : ${stu.stuId}, 이름 : ${stu.stuName}, # 국어 : ${stu.kor}, # 영어 : ${stu.eng},
			# 수학 : ${stu.math}, # 총점 : ${stu.total}, # 평균 : ${stu.average}
			<a href="<c:url value='/score/delete?stuNum=${stu.stuId}'/>">[삭제]</a>
		</p>
	</c:forEach>
	<!-- 삭제 인자로 학생 번호를 전달 -->
	
	<a href="<c:url value='/score/register'/>">다른 점수 등록하기</a>
	
	<script type="text/javascript">
		const msg = "${msg}";	/* const : 상수, let : 변수, var : const + let */
		if(msg === "delSuccess"){
			alert("삭제가 완료되었습니다.");
		}
	</script>
</body>
</html>