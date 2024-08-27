package com.example;



import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.example.service.CustomUserDetails;
import com.example.service.CustomUserDetailsService;


@CrossOrigin
@Configuration                    // Spring Security 설정 클래스
@EnableWebSecurity                // Spring Security 웹 보안 활성화
//@RequiredArgsConstructor          // 필수 의존성 자동 주입 (final 필드에 대해 생성자 자동 생성)
public class SecurityConfig {
	
	
	
	private final CustomUserDetailsService customUserDetailsService;
	
	public SecurityConfig(CustomUserDetailsService customUserDetailsService) {
		this.customUserDetailsService = customUserDetailsService;
	}
	
	
//    private final JwtTokenProvider jwtTokenProvider;

//    @Bean
//    public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
//
//        httpSecurity.httpBasic().disable()                // 기본 로그인 화면 비활성화 (JWT 사용하므로 불필요)
//            .cors()                                      // CORS 설정 (필요에 따라 별도 설정 추가 가능)
//            .and()
//            .csrf().disable()                            // CSRF 보호 비활성화 (JWT와 함께 사용할 때 주로 비활성화)
//            .sessionManagement()
//            .sessionCreationPolicy(SessionCreationPolicy.STATELESS)  // 세션을 사용하지 않으므로 Stateless 설정
//            .and()
//            .authorizeHttpRequests()
//            .requestMatchers("/users/JWTlogin").permitAll()  // JWT 로그인 엔드포인트는 인증 없이 접근 허용
//            .requestMatchers(HttpMethod.GET, "/bbs/**").permitAll()  // GET 요청에 대해 /bbs/** 경로는 모두 접근 허용
//            .anyRequest().authenticated()                   // 그 외의 모든 요청은 인증이 필요
//            .and()
//            .addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider), UsernamePasswordAuthenticationFilter.class); 
//            // JWT 인증 필터를 UsernamePasswordAuthenticationFilter 전에 추가 (JWT 기반 인증 처리)
//        
//        return httpSecurity.build();
//    }

   
    // 이전에 시도했던 다른 암호화 알고리즘 예시는 주석 처리되어 있습니다.
    // Argon2 또는 Sha256 알고리즘을 사용할 때는 JWT와의 호환성을 확인하고 사용해야 합니다.
    // BCrypt는 널리 사용되고 안전하며, Spring Security에서 기본적으로 잘 지원됩니다.

//    @Bean
//    SecurityFilterChain filterChain1(HttpSecurity http) throws Exception {
//        http.csrf(csrf -> csrf.disable());  // CSRF 비활성화 (필요한 경우 설정 가능)
//        return http.build();
//    }
    
    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception{
    	http
    		.cors(cors -> cors.and()) //CORS허용
    		.csrf(csrf -> csrf.disable())//CSRF비활성화( JWT 또는 세션 방식에 따라 선택)
    		.sessionManagement(session -> session
    				.sessionCreationPolicy(SessionCreationPolicy.IF_REQUIRED)) //필요한 경우에만 세션 생성
    				.authorizeHttpRequests((requests)-> requests
    						.requestMatchers("/admin/**").hasRole("ADMIN") // 데이터베이스에 'role_admin'이 있으면 해당 권한을 매핑 ,ADMIN 역할만 접근 가능
    						.requestMatchers("/users/**","/bbs").hasAnyAuthority("USER", "VISITOR", "ADMIN") // 'role_user', 'role_visitor' 등 매핑
    						.requestMatchers("/", "/register", "/login", "/users/**","/bbs").permitAll() //누구나 접근 가능 (회원가입, 로그인 포함)
    						.anyRequest().authenticated()  //그 외의 모든 요청은 인증이 필요
    						);
    	
//    	
//    		.cors(cors-> cors.disable()) //CORS비활성
//    		.csrf(csrf -> csrf.disable())
//    		.authorizeHttpRequests((requests) -> requests
//    			.requestMatchers("/admin/**").hasRole("ADMIN") //ADMIN역할만 접근 가능
//    			.requestMatchers("/user/**").hasAnyRole("user", "ADMIN") // user, admin 둘 다 접근가능
//    			.requestMatchers("/", "/register", "/login").permitAll() //누구나 접근 가능
//    			.anyRequest().authenticated() // 그 외의 모든 요청은 인증 필요
//    			)
//    		.formLogin((form)-> form
//    				.loginPage("http://localhost:3000/login") //사용자 정의 로그인 페이지
//    				.defaultSuccessUrl("/bbs") //로그인 성공 시 페이지
//    				.permitAll() //로그인 페이지는 누구나 접근 가능
//    				)
//    		.logout((logout)-> logout
//    				.logoutUrl("/logout")
//    				.logoutSuccessUrl("/login")
//    				.permitAll() //로그아웃 페이지도 누구나 접근 가능
//     			);
//    	
    	return http.build();
 
    	
    }
//    @Bean
//    public WebMvcConfigurer corsConfigurer() {
//    	return new WebMvcConfigurerAdapter() {
//    		@Override
//    		public void addCorsMappings(CorsRegistry registry) {
//    			registry.addMapping("/**")
//    				.allowedOriginPatterns("http://localhost:3000")
//    				.allowedMethods("GET","POST","PUT","DELETE");
//    				
//    		}
//    	};
//    }
//    
    @Bean
    PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();  // BCryptPasswordEncoder를 사용한 비밀번호 암호화
    }

 // 사용자 인증 처리를 위한 configure 메서드
AuthenticationManagerBuilder configure(AuthenticationManagerBuilder auth) throws Exception {
    	auth.userDetailsService(customUserDetailsService)
    	.passwordEncoder(encoder());
    	return auth;
    }
    
}
