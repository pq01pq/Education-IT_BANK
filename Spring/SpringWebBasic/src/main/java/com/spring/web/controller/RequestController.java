package com.spring.web.controller;

import java.util.Arrays;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.spring.web.model.UserDB;
import com.spring.web.model.UserVO;

// 자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션
// 빈을 등록 해 놔야 HandlerMapping이 이 클래스의 객체를 검색할 수 있음
@Controller	@RequestMapping("/request")
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestCon 빈 등록!");
	}
	
	// RequestMapping은 어떤 URI로 이 메서드를 동작시킬 것인가에 대한 설정
	//@RequestMapping("/request/test")
	@RequestMapping("/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}
	
	/*
	 만약 /request/req 요청이 들어왔을 때
	 views 폴더 아래에 있는 request 폴더 아래에
	 req-ex01.jsp 파일을 열도록 메서드를 구성
	 */
	
	//@RequestMapping("/request/req")
	@RequestMapping("/req")
	public String req() {
		System.out.println("/request/req 요청이 들어옴!");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01", method=RequestMethod.GET)
	//@GetMapping("/request/basic01")	// spring 4부터 사용 가능
	@GetMapping("/basic01")
	public String basicGet() {
		System.out.println("/request/basic01 요청 들어옴 : get");
		return "request/req-ex01";
	}
	
	//@RequestMapping(value="/request/basic01", method=RequestMethod.POST)
	//@PostMapping("/request/basic01")	// spring 4부터 사용 가능
	@PostMapping("/basic01")
	public String basicPost() {
		System.out.println("/request/basic01 요청 들어옴 : post");
		return "request/req-ex01";
	}
	
	// 컨트롤러의 요청 메서드를 void 리턴 타입으로 지정
	// 맵핑 uri의 경로를 파일 이름으로 사용
	@GetMapping("/req-ex02")
	public void reqEx02() {
		System.out.println("/requset/req-ex02 요청");
	}
	
	/////////////////////////////////////////////////////////////////////////
	
	@GetMapping("/join")
	public void register() {
		System.out.println("/request/join : get");
	}
	
	/*
	 1. 전통적인 jsp servlet 방식의 파라미터 읽기 처리 방법
	 - HttpServletRequest 객체 활용
	 */
	
	/*
	 @PostMapping("/join")
	 public void register(HttpServletRequest request) {
	 System.out.println("/request/join : post");
	 
	 System.out.println("ID : " + request.getParameter("userId"));
	 System.out.println("PW : " + request.getParameter("userPw"));
	 System.out.println("NAME : " + request.getParameter("userName"));
	 System.out.println("Hobby : " +
	 Arrays.deepToString(request.getParameterValues("hobby"))); }
	 */
	
	/*
	 2. @RequestParam 어노테이션을 이용한 요청 파라미터 처리
	 */
	
/*	@PostMapping("/join")
	public void register(@RequestParam("userId") String id,
			@RequestParam("userPw") String pw,
			@RequestParam("userName") String name,
			@RequestParam(value = "hobby", required = false,
							defaultValue = "no hobby person") List<String> hobbies) {
		// RequestParam은 기본적으로 null값을 받을 수 없음
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("NAME : " + name);
		System.out.println("HOBBY : " + hobbies);
	}*/
	
	/*
	 3. 커맨드 객체를 활용한 파라미터 처리
	 */
	@PostMapping("/join")
	public void register(UserVO user) {
//		System.out.println("ID : " + user.getUserId());
//		System.out.println("PW : " + user.getUserPw());
//		System.out.println("NAME : " + user.getUserName());
//		System.out.println("HOBBY : " + user.getHobbies());
		System.out.println(user);
	}
	
	// req-quiz
	@GetMapping("/quiz")
	public String quiz() {
		return "request/req-quiz";
	}
	
//	@PostMapping("/quiz")
//	public String quiz(@RequestParam("userId") String id,
//			@RequestParam("userPw") String pw) {
//		if(id.equals("abc1234") && pw.contentEquals("aaa1111")) {
//			return "request/login-sucsess";
//		} else {
//			return "request/login-fail";
//		}
//	}
	
	@PostMapping("/quiz")
	public String quiz(UserVO vo) {
		if(vo.getUserId().equals("abc1234") && vo.getUserPw().equals("aaa1111")) {
			return "request/login-success";
		} else {
			return "request/login-fail";
		}
	}
}