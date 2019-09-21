package com.bit.research.dao;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.bit.research.vo.Users;

@Repository
public class UserDAO {

	@Inject
	private SqlSession sql;
	
	private static final String Namespace="com.bit.research.users";
	
	/* 유저 전체 조회 */
	public List<Users> listAll() {
		return sql.selectList(Namespace+".listAll");		
	}
	
	/* 유저 추가 */
	public int addUser(Users vo) {
		return sql.insert(Namespace+".addUser", vo);
	}
	
	/* 아이디로 조회 */
	public Users readUser(String inputId) {
		return sql.selectOne(Namespace+".readUser", inputId);
	}
	
	/* 로그인 */
	public Users signInUser(Users vo) {
		return sql.selectOne(Namespace+".signInUser",vo);
	}
	
	/* test */
	public Users test(Users vo) {
		return sql.selectOne(Namespace+".test", vo);
	}

}
