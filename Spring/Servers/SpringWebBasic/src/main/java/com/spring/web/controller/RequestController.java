package com.spring.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

//자동으로 스프링 컨테이너에 해당 클래스의 빈을 등록하는 아노테이션.
//빈을 등록 해 놔야 HandlerMapping이 이 클래스의 객체를 검색할 수 있을 것이다.
@Controller
public class RequestController {
	
	public RequestController() {
		System.out.println("RequestCon 빈 등록!");
	}
	
	//RequestMapping은 어떤 URI로 이 메서드를 동작시킬 것인가에 대한 설정입니다.
	@RequestMapping("/request/test")
	public String testCall() {
		System.out.println("/request/test 요청이 들어옴!");
		return "test";
	}

}



















