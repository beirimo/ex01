package com.example.service;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.dao.UserDAO;
import com.example.domain.UserVO;


@Service
public class CustomUserDetailsService implements UserDetailsService{
	
	private final UserDAO dao;
	
	public CustomUserDetailsService(UserDAO dao) {
		this.dao = dao;
		
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserVO user = dao.login(username);   //사용자 정보를 데이터베이스에서 조회
		if(user == null) {
			throw new UsernameNotFoundException("사용자 이름을 찾지 못했습니다: " + username);
		}
		return new CustomUserDetails(user); //UserDetails 인터페이스를 구현한 사용자 정보 반환
	}

}
