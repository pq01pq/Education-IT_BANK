package com.spring.basic.ex04;

import javax.annotation.Resource;

public class Book {
	/*
	 @Resource
	 - 빈을 자동으로 주입하는 어노테이션
	 - 필드, 메서드에만 적용 가능, 생성자에서는 적용 불가
	 - name 속성을 통해 특정 bean id를 지목 가능
	 - jdk 8버전까지만 사용 가능
	 */
	
	@Resource(name="paper2")	// == @Autowired + @Qualifier("paper2")
	private Paper paper;
	
//	public void setPaper(Paper paper) {
//		this.paper = paper;
//	}
	public Paper getPaper() {
		return paper;
	}
}
