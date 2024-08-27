package com.example.util;

import java.util.Date;




import org.springframework.stereotype.Component;


import com.example.domain.UserVO;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@Component
public class JWTutil {
	
	//jwt 토큰 생성을 위한 시크릿 키
	private final String secret_key = "pass1234";
	
	// 토큰 생성 메서드
	public String generateToken(UserVO vo) {
		long expirationTime = 1000 * 60 * 60 *24;// 24시간 유효  - 보안을 위해 15분으로 맞춰주는 것 필요할 수 있음.
		
//		
//		return Jwts.builder()
//				.setSubject(vo.getUid())
//				.setIssuedAt(new Date())
//				.setExpiration(new Date(System.currentTimeMillis() + expirationTime))
//				.signWith(SignatureAlgorithm.HS512, secret_key)
//				.compact();
		
		 return Jwts.builder()
		            .setSubject(vo.getUid()) // 사용자 ID를 토큰의 주체(subject)로 설정
		            .setIssuedAt(new Date()) // 토큰 발행 시간 설정
		            .setExpiration(new Date(System.currentTimeMillis() + expirationTime)) // 토큰 만료 시간 설정
		            .signWith(SignatureAlgorithm.HS512, secret_key) // 서명 알고리즘 및 비밀 키 설정
		            .compact(); // 토큰 생성 및 반환
	}
	// 토큰 검증 메서드(선택 사항, 필요 시 구현)
	public boolean validateToken(String token, UserVO vo) {
		String uid = Jwts.parser()
				.setSigningKey(secret_key)
				.parseClaimsJws(token)
				.getBody()
				.getSubject();
		return (uid.equals(vo.getUid()) && !isTokenExpired(token));
	}
	//토큰 만료 확인 메서드
	
	private boolean isTokenExpired(String token) {
		Date expiration = Jwts.parser()
				.setSigningKey(secret_key)
				.parseClaimsJws(token)
				.getBody()
				.getExpiration();
		return expiration.before(new Date());
	}

}
