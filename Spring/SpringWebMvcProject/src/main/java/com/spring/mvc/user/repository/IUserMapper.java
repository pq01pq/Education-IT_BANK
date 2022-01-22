package com.spring.mvc.user.repository;

import com.spring.mvc.user.model.UserVO;

public interface IUserMapper {
	// 아이디 중복 체크 기능
	int checkID(String account);
	
	// 회원가입 기능
	void register(UserVO user);
	
	// 회원정보 조회 기능
	UserVO selectOne(String account);
	
	// 회원탈퇴 기능
	void delete(String account);
}
