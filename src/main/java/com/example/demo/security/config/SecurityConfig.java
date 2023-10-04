package com.example.demo.security.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.example.demo.users.repository.UsersRepository;
import com.example.demo.security.jwt.JwtAuthenticationFilter;
import com.example.demo.security.jwt.JwtAuthorizationFilter;
import com.example.demo.security.service.CorsConfig;

//[1] POSTMAN에서 테스트
//POST http://localhost:8090/login
//boy, raw , json  => {"memberEmail":"aaa@naver.com", "memberPass":"1234"}


@Configuration          //환경설정에 관한 태그
@EnableWebSecurity   //SpringSecurityFilterChain에 등록
@EnableGlobalMethodSecurity(securedEnabled = true)
public class SecurityConfig {
	
	@Autowired
	private UsersRepository userRepository; 
 
	@Bean
	public BCryptPasswordEncoder encodePassword() {
		return new BCryptPasswordEncoder();
	}
	
	@Autowired
	private CorsConfig corsConfig;
	
	
	@Bean
	SecurityFilterChain filterChain(HttpSecurity http) throws Exception{
		
		//csrf() : Cross Site Request Forgery로 사이트간 위조 요청으로 정상적인 사용자가 의도치 않은
		//위조 요청을 보내는 것을 의미한다.
		http.csrf().disable();
		//API을 사용하므로 기본으로 제공하는 formLogin()페이지 끄기
		http.formLogin().disable();	
		
		http.httpBasic().disable();	
		
		
		
		//세션끄기 : JWT를 사용하기 때문에 세션을 사용하지 않는다.
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);	
		
		//인증사용, Security Filter에 등록 , @CrossOrigin (인증X)
		http.apply(new MyCustomerFilter());
		
		//요청에 의한 인가(권한)검사 시작
		http.authorizeHttpRequests()
		.antMatchers("/", "/images/**",  "/login", "/join","/users/email", "/mypage/*",
				     "/info/**").permitAll() // 로그인 없이 접근 허용한다.
		.anyRequest().authenticated() ; //그외  모든 요청에 대해서 인증(로그인)이 되어야 허용한다.
		
		return http.build();
	}
	
	
	
	public class MyCustomerFilter extends AbstractHttpConfigurer<MyCustomerFilter, HttpSecurity>{
		@Override
		public void configure(HttpSecurity http) throws Exception {
			AuthenticationManager authenticationManager = http.getSharedObject(AuthenticationManager.class);
			
			// @CrossOrigin(인증 X), Security Filter에 등록 인증(O)
			http.addFilter(corsConfig.corsFilter());
			
			//addFilter() : FilterComparator에 등록되어 있는 Filter들을 활성화할 때 사용
			//adddFilterBefore(), addFilterAfter() : CustomFilter를 등록할 때 사용
			//인증 필터 등록
			http.addFilter(new JwtAuthenticationFilter(authenticationManager))
			//인가(권한) 필터 등록
			 .addFilter(new JwtAuthorizationFilter(authenticationManager, userRepository));
			
		}
	}
	
}//end outer class











