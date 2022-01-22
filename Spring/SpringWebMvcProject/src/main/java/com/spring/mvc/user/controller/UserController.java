package com.spring.mvc.user.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.spring.mvc.user.model.UserVO;
import com.spring.mvc.user.service.IUserService;

@RestController @RequestMapping("/user")
public class UserController {
	@Autowired
	private IUserService service;
	
	// 아이디 중복 확인 요청 처리
	@PostMapping("/checkID")
	public String checkID(@RequestBody String account) {
		// sql문은 count(*)를 이용, 해당 id로 데이터베이스에서 검색이 되었다면 no를
		// 검색이 되었다면 ok를 리턴
		System.out.println("/user/checkID : post 요청 발생");
		System.out.println("param : " + account);
		
		int checkNum = service.checkID(account);
		if(checkNum == 1) {
			System.out.println("중복된 아이디");
			return "no";
		} else {
			System.out.println("사용 가능한 아이디");
			return "ok";
		}
	}
	
	// 회원가입 요청 처리
	@PostMapping("/")
	// @RequestBody : 자바형식으로 변환
	public String register(@RequestBody UserVO user) {
		System.out.println("/user/ : post 요청 발생");
		System.out.println("param : " + user);
		
		service.register(user);
		
		return "joinSuccess";
	}
	
	// 로그인 요청 처리
	@PostMapping("/loginCheck")
	public String loginCheck(@RequestBody UserVO checkUser,
								/*HttpServletRequest request*/ HttpSession session) {
		/*
		- 클라이언트가 전송한 id값과 pw값을 가지고
		db에서 회원의 정보를 조회하여 불러온 다음, 값 비교를 통해
		1. 아이디가 없는 경우 클라이언트 측으로 문자열 fail 전송
		2. 비밀번호가 틀렸을 경우 문자열 pwFail 전송
		3. 로그인 성공 시 문자열 loginSuccess 전송
		*/
		
		// 서버에서 세션 객체를 얻는 방법
		// 1. HttpServletRequest 객체 사용
		//HttpSession session = request.getSession();
		
		// 2. HttpSession객체 바로 사용
		
		System.out.println("/user/loginCheck : post 요청");
		System.out.println("param : " + checkUser);
		
		UserVO user = service.selectOne(checkUser.getAccount());
		String result = null;
		
		if(user != null) {
			if(user.getPassword().equals(checkUser.getPassword())) {
				session.setAttribute("login", user);
				result = "loginSuccess";
			} else {
				result = "pwFail";
			}
		} else {
			result = "idFail";
		}
		
		return result;
	}
	
	// 로그아웃 처리
	@GetMapping("/logout")
	public ModelAndView logout(HttpSession session) {
		System.out.println("/user/logout : get 요청");
		session.invalidate();
		
		return new ModelAndView("redirect:/");
	}
}
