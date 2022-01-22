package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.spring.web.model.UserVO;

@Controller	@RequestMapping("/response")
public class ResponseController {
	
	@GetMapping("/res-ex01")
	public void resEx01() {}
	
	/*
	// 1. Model 객체를 사용하여 화면에 데이터 전송하기
	
	@GetMapping("/test") public void test(@RequestParam("age") int age, Model model) {
		model.addAttribute("age", age);
		model.addAttribute("nickname","댕댕이");
	}
	// Model 객체가 넘어갈 페이지로 매개변수를 담아서 보냄
	*/
	
	// 2. @ModelAttribute를 사용한 화면에 데이터 전송 처리
	// @ModelAttribute == @RequestParam + model.addAttribute
	@GetMapping("/test")
	public void test(@ModelAttribute("age") int age, Model model) {
		// model.addAttribute("age", age);	// @ModelAttribute가 이미 매개변수로 지정했음
		model.addAttribute("nickname", "댕댕이");
	}
	
	// 3. ModelAndView 객체를 활용한 처리
	@GetMapping("/test2")
	public ModelAndView test2() {
//		ModelAndView mv = new ModelAndView();
//		mv.addObject("userName", "김철수");
//		mv.setViewName("/response/test2");
		
		return new ModelAndView("/response/test2", "userName", "홍길동");
	}
	
	// res-ex02.jsp파일을 열람하는 요청 메서드를 작성
	@GetMapping("/res-ex02")
	public void resEx02() {}
	
	@PostMapping("/join")
	public String join(@ModelAttribute("user") UserVO user) {
		//model.addAttribute("user", user);
		
		return "response/test3";
	}
	
	//////////////////////////////////////////////////////////////////////////////
	
	// 퀴즈
	
	// 퀴즈 화면 처리
	@GetMapping("/res-quiz")
	public void resQuiz() {}
	
	/*
	// 커맨드 객체와 Model을 사용한 방식
	@PostMapping("/res-login")
	public String resLogin(UserVO vo, Model model) {
		String id = vo.getUserId();
		String pw = vo.getUserPw();
		
		model.addAttribute("userId", id);
		
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		} else {
			return "response/res-quiz-fail";
		}
	}*/
	
	@PostMapping("res-login")
	public String resLogin(@ModelAttribute("userId") String id,
			@RequestParam("userPw") String pw) {
		
		if(id.equals("kim123") && pw.equals("kkk1234")) {
			return "response/res-quiz-success";
		} else {
			return "response/res-quiz-fail";
		}
	}
	
	///////////////////////////////////////////////////////////////////
	
	// redirect 처리
	
	@GetMapping("/login")
	public String login() {
		System.out.println("/login : get 요청 발생");
		return "response/res-redirect-form";
	}
	
	@PostMapping("/login")
	public String login(@RequestParam("userId") String id,
			@RequestParam("userPw") String pw,
			@RequestParam("userPwChk") String pwChk, RedirectAttributes ra) {
		System.out.println("/login : post 요청 발생");
		System.out.println("ID : " + id);
		System.out.println("PW : " + pw);
		System.out.println("CHK : " + pwChk);
		
		if(id.equals("")) {
			//model.addAttribute("msg", "아이디는 필수값입니다.");
			// model은 응답이 나가면 소멸하기 때문에 redirect할 때 url로 매개변수로 보냄
			ra.addFlashAttribute("msg", "아이디는 필수값입니다.");
			// RedirectAttributes 객체는 요청에 매개변수를 담아서 보냄
			return "redirect:/response/login";
			// redirect는 get방식으로 요청을 전송함
		} else if(!pw.equals(pwChk)) {
			ra.addFlashAttribute("msg", "비밀번호 확인란을 체크하십시오.");
			return "redirect:/response/login";
		}
		
		return "";
	}
}
