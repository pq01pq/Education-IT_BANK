package com.spring.basic.ex04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

public class Printer {
	
	/*
	 @Autowired
	 - 객체를 자동 주입할 때 사용하는 어노테이션
	 - 스캔 명령을 통해 객체를 찾아 주입하는데, 타입 이름으로 검색
	 - 타입을 찾아내지 못하면 이름(id 속성값)을 통해 검색
	 - 생성자, 메서드, 필드에 적용 가능
	 
	 @Qualifier("bean id")
	 - Autowired를 사용할 때 동일 타입의 빈이 여러개 있을 경우
	 어떤 빈을 주입해야 하는지 선택해주는 추가 어노테이션
	 */
	
	// 객체 id가 여러개일 때 @Autowired만 쓰면 에러남
	@Autowired	@Qualifier("paper1")	// bean id
	private Paper paper;
	// bean id로 자동으로 객체를 주입하기 때문에
	// 생성자나 setter 메서드를 생략할 수 있음
	
//	@Autowired
//	public Printer(Paper paper) {
//		this.paper = paper;
//	}
	
//	@Autowired
//	public void setPaper(Paper paper) {
//		this.paper = paper;
//	}
	
	public void showPaperInfo() {
		for(String info : paper.data) {
			System.out.println(info);
		}
	}
}
