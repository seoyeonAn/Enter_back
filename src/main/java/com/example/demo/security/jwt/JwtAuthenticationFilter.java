package com.example.demo.security.jwt;



import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;


import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.example.demo.security.service.PrincipalDetails;
import com.example.demo.users.dto.UsersDTO;
import com.fasterxml.jackson.databind.ObjectMapper;

//Authentication(인증)
public class JwtAuthenticationFilter extends UsernamePasswordAuthenticationFilter {
	
	private AuthenticationManager authManager;
	
	public JwtAuthenticationFilter(AuthenticationManager authManager) {
		this.authManager = authManager;	
	}
	
	// http://localhost:8090/login 요청을 하면 실행되는 함수
	
	@Override
	public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response)
			throws AuthenticationException {
		System.out.println("JwtAuthenticationFilter => login 요청 처리를 시작함");
		
		
		try {
			
//			 BufferedReader br = request.getReader();
//			 String input = null;
//			 while((input=br.readLine())!=null) {
//				System.out.println(input);
//			}
			
			 ObjectMapper om = new ObjectMapper();
			 UsersDTO user = om.readValue(request.getInputStream(), UsersDTO.class);
			 System.out.printf("Email : %s, Password:%s\n", user.getEmail(), user.getPassword());
	
			 
			 UsernamePasswordAuthenticationToken authenticationToken = 
					 new UsernamePasswordAuthenticationToken(user.getEmail(), user.getPassword());
			 System.out.println("여기야!");		 
			 
			 
			 Authentication authentication = authManager.authenticate(authenticationToken);
			 System.out.println("authencation :" + authentication.getPrincipal());
			
			 
			PrincipalDetails principalDetails = (PrincipalDetails)authentication.getPrincipal();
			System.out.printf("로그인 완료됨(인증) : %s %s\n", principalDetails.getUsername(), principalDetails.getPassword());
			 
			 return authentication;
		} catch (IOException e) {
			e.printStackTrace();
		}		 
		
		return null;
	}	
	
	
	//attemptAuthentication() 실행 후 인증이 정상적으로 완료되면 실행된다.
	//여기에서 JWT(JSON WEB TOKEN) 토큰을 만들어서 request요청한 사용자에게 JWT 토큰을 response 해준다.
	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authResult) throws IOException, ServletException {		
		
		System.out.println("successfulAuthentication 실행됨");
		
		PrincipalDetails principalDetails = (PrincipalDetails)authResult.getPrincipal();
		
		String jwtToken = JWT.create()
				.withSubject("mycors")
				.withExpiresAt(new Date(System.currentTimeMillis() + (600 * 1000 * 600 *1L)))//만료시간 3분
				.withClaim("Password", principalDetails.getUersDTO().getPassword()) //회원 이름
                .withClaim("email", principalDetails.getUersDTO().getEmail()) //회원메일
                .withClaim("name", principalDetails.getUersDTO().getName())

                .sign(Algorithm.HMAC512("mySecurityCos")); //signature을 생성하기 위한 security
		
		System.out.println("jwtToken:" + jwtToken);
		
		//response 응답헤더에 jwtToken 추가
		response.addHeader("Authorization", "Bearer " + jwtToken);
		
		final Map<String, Object> body = new HashMap<String, Object>();
		body.put("usersName", principalDetails.getUersDTO().getName());
		body.put("email", principalDetails.getUersDTO().getEmail());
		body.put("name", principalDetails.getUersDTO().getName());
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(response.getOutputStream(), body);		
	}
	
	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException failed) throws IOException, ServletException {
		System.out.println("unsuccessfulAuthentication 실행됨");
		response.setStatus(HttpStatus.UNAUTHORIZED.value());
        response.setContentType(MediaType.APPLICATION_JSON_VALUE);
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("code", HttpStatus.UNAUTHORIZED.value());
        body.put("error", failed.getMessage());

        new ObjectMapper().writeValue(response.getOutputStream(), body);
	}	
	
}//end class
