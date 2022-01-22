package com.spring.basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		/*
		DataBaseInfo dbInfo = new DataBaseInfo();
		dbInfo.setUid("spring1");
		dbInfo.setUpw("sss111");
		dbInfo.setUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		
		DataBaseInfo dbInfo2 = new DataBaseInfo();
		dbInfo2.setUid("spring2");
		dbInfo2.setUpw("sss222");
		dbInfo2.setUrl("jdbc:mysql://localhost:3306/spring");
		
		MemberDAO dao = new MemberDAO();
		dao.setDbInfo(dbInfo);
		dao.showDBInfo();
		*/
		
		GenericXmlApplicationContext ct = 
				new GenericXmlApplicationContext("classpath:db-config.xml");
		
		MemberDAO dao = ct.getBean("dao", MemberDAO.class);
		dao.showDBInfo();

	}

}























