package com.example.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.domain.UserVO;

@Repository
public class UserDAOImpl implements UserDAO{
	
	@Autowired
	SqlSession session;
	String namespace="com.example.mapper.UserMapper";

	@Override
	public UserVO login(String uid) {
		return session.selectOne(namespace + ".login", uid);
	}

	@Override
	public int check(String uid) {
		
		return session.selectOne(namespace +".check", uid);
	}

//	@Override
//	public void save(UserVO vo) {
//		 session.selectOne(namespace + ".save", vo);
//					selectOne은 하나의 레코드를 조회하는거니까 
//					insert를 사용
//		
//	}
	@Override
	public void save(UserVO vo) {
		 session.insert(namespace + ".save", vo);
		
	}

	@Override
	public UserVO mypage(String uid) {
		return session.selectOne(namespace + ".mypage", uid);
	}

	@Override
	public void myupdate(UserVO vo) {
		session.update(namespace + ".myupdate",vo);
		
	}

}
