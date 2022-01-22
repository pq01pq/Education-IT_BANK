<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
//start jQuery
$(function() {
   
   const getIdCheck = RegExp(/^[a-zA-Z0-9]{4,14}$/);
   
   
   //회원 가입시 사용자의 입력값 검증!
   
   //ID 입력값 검증.
   $("#user_id").on('keyup', function() {
      if($("#user_id").val() === "") {
         $("#user_id").css("background-color", "pink");
         $("#idChk").html('<b style="font-size:14px; color:red;">[아이디는 필수 정보에요!]</b>');
      }
      //아이디 입력값 유효성 검사
      else if(!getIdCheck.test($("#user_id").val())) {
         $("#user_id").css("background-color", "pink");
         $("#idChk").html('<b style="font-size:14px; color:red;">[영문자, 숫자 4-14자로 작성!!]</b>');
      }
      
      //ID 중복확인 비동기 처리
      else {
         
         //ID 중복확인 통신을 위해 id값을 가져오기.
         const id = $(this).val();
         console.log(id);
         
         //ajax 호출
         $.ajax({
            type: "POST",
            url: "/user/checkId",
            headers: {
               "Content-Type" : "application/json"
            },
            dataType: "text",
            data: id,
            success: function(result) {
               console.log("통신 성공: " + result);
               if(result === "OK") {
                  $("#user_id").css("background-color", "aqua");
                  $("#idChk").html('<b style="font-size:14px; color:green;">[아이디 사용이 가능합니다!]</b>');

               } else {
                  $("#user_id").css("background-color", "pink");
                  $("#idChk").html('<b style="font-size:14px; color:red;">[아이디가 중복됨!]</b>');

               }
            },
            error: function() {
               console.log("통신 실패!");
            }
         }); //ajax (아이디 중복 확인)
         
      }
      
   }); //아이디 검증 끝.
   
   
   
   
   //사용자가 회원 가입 버튼을 눌렀을 때 이벤트 처리
   $("#signup-btn").click(function() {
      
      //아이디 정보
      const id = $("#user_id").val();
      //패스워드 정보
      const pw = $("#password").val();
      //이름 정보
      const name = $("#user_name").val();
      
      const user = {
            account : id,
            password : pw,
            name : name
      };
      
      //비동기 통신 시작!
      //클라이언트에서 서버와 통신하는 ajax함수 (비동기 통신)
      $.ajax({
         type: "POST", //서버에 전송하는 HTTP 방식
         url: "/user/", //서버 요청 URL
         headers: {
            "Content-Type" : "application/json"
         }, //요청 헤더 정보
         dataType: "text", //서버로부터 응답받을 데이터의 형태
         data: JSON.stringify(user), //서버로 전송할 데이터
         success: function(result) { //서버와의 통신 성공 시 실행할 내용. 매개변수는 통신 성공 시 데이터가 저장될 곳.
            console.log("통신 성공!: " + result);
         },
         error: function() {
            console.log("통신 실패!");
         }
         
      }); //end ajax
      
      
      
   }); //signup-btn 이벤트 처리 끝.
   
   
}); //end jQuery
</body>
</html>

