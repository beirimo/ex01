package com.example.service;

import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.domain.UserVO;

public class CustomUserDetails implements UserDetails{
	
	private final UserVO user;
	
	public CustomUserDetails(UserVO user) {
		this.user =user;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
	
		
		return List.of(new SimpleGrantedAuthority(user.getRole()));  //사용자 권한을 반환
//		SimpleGrantedAuthority는 권한을 문자열로 반환하는 것 - 권한 -> role_user,role_admin 등
	
	}

	@Override
	public String getPassword() {
		
		return user.getUpass();	//암호화된 비밀번호를 반환
	}

	@Override
	public String getUsername() {
		
		return user.getUid(); //사용자 ID 반환
	}
	
	@Override
	public boolean isAccountNonExpired() {
		
		//계정 만료 여부 반환(true이면 만료되지 않음)
		return true;
		
	}
	@Override
	public boolean isAccountNonLocked() {
		//계정이 잠겨있지 않으면 true 반환
		return true;
	}
	// 추가로 구현할 수 있는 메서드들:
    // - isCredentialsNonExpired(): 비밀번호가 만료되지 않았는지 여부를 반환
    // - isEnabled(): 계정이 활성화되어 있는지 여부를 반환

}
