package com.spring.basic.ex02;

import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
/*		DatabaseInfo dbInfo = new DatabaseInfo();
		dbInfo.setUid("spring1");
		dbInfo.setUpw("sss111");
		dbInfo.setUrl("jdbc:oracle:thin:@localhost:1521/XEPDB1");
		
		DatabaseInfo dbInfo2 = new DatabaseInfo();
		dbInfo.setUid("spring2");
		dbInfo.setUpw("sss222");
		dbInfo.setUrl("jdbc:mysql://@localhost:3306/spring");
		
		MemberDAO dao = new MemberDAO();
		dao.setDbInfo(dbInfo);
		dao.showDbInfo();*/
		
		GenericXmlApplicationContext ct =
				new GenericXmlApplicationContext("classpath:db-config.xml");
		
		MemberDAO dao = ct.getBean("dao", MemberDAO.class);
		dao.showDbInfo();
		
		ct.close();
	}

}
