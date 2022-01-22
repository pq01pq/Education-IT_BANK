package com.spring.basic;

import org.springframework.context.support.GenericXmlApplicationContext;

public class HelloSpring {

	public static void main(String[] args) {
//		SpringTest st = new SpringTest();
//		st.hello();
		
		GenericXmlApplicationContext ct =
				new GenericXmlApplicationContext("classpath:test-config.xml");
		// classpath : scr/main/resources 폴더
		
		SpringTest st = ct.getBean("test", SpringTest.class);
		// "test" : 클래스 이름
		// SpringTest.class : SpringTest 객체를 class 타입으로 리턴
		
		st.hello();
		
		ct.close();
	}

}
