//package com.example.util;
//
//import org.slf4j.Logger;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.stereotype.Component;
//
//import jakarta.annotation.PostConstruct;
//import lombok.RequiredArgsConstructor;
//import lombok.Value;
//
//@Component
//@RequiredArgsConstructor    //생성자로 의존성 주입받을 때 final 필드들은 이 어노테이션으로 주입 가능
//public class JwtTokenProvider {
//	 private final Logger log = LoggerFactory.getLogger(JwtTokenProvider.class);
//	    private final UserDetailsService userDetailsService;
//	    private final RedisTemplate redisTemplate;
//	    
//	    @Value("${springboot.jwt.secret}")
//	    private String secretKey = "secretKey";
//	    
//	    private final long tokenValidMilliSecond = 1000L * 60 * 60;
//	    private final long refreshValidMilliSecond = tokenValidMilliSecond * 24;
//	    
//	    @PostConstruct        //해당 객체가 주입된 이후 수행되는 메서드 지정
//	    protected void init(){
//	        log.info("init ==> secret 키 초기화 시작");
//	        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes(StandardCharsets.UTF_8));  //secret key를 base64형식으로 인코딩한다.
//	        log.info("init ==> secret 키 초기화 완료");
//
//}
//
//		public Authentication getAuthentication(String token) {
//			// TODO Auto-generated method stub
//			return null;
//		}
//}
