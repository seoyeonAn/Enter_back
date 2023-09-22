package com.example.demo.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//로그인 성공 후 인증 상태 정보를 세션에 보관할 때 사용

@NoArgsConstructor
@Getter
public class AuthInfo {
	private String email;
	private String name;
	private String password;
	
	public AuthInfo(String email,  String password) {
		super();
		this.email = email;
		
		this.password = password;
	}
	  
	public AuthInfo(String email, String name, String password) {
		super();
		this.email = email;
		this.name = name;
		this.password = password;
	}
}
