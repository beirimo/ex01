package com.example.dao;

import com.example.domain.UserVO;

public interface UserDAO {
	public UserVO login(String uid);
	public int check(String uid);
	public void save(UserVO vo);
	public UserVO mypage(String uid);
	public void myupdate(UserVO vo);
	
	

}
