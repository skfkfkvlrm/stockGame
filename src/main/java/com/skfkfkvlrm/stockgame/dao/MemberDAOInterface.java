package com.skfkfkvlrm.stockgame.dao;

import java.util.Map;

public interface MemberDAOInterface {

	// 회원가입
	boolean setMember(String studentId, String password, String name, int grade, String className, int classNumber);

	// 로그인
	Map<String, Object> login(String studentId, String password);

	// 아이디 중복체크
	boolean getIdCheck(String studentId);
}
