package com.example.demo.users.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

//로그인 성공 후 인증 상태 정보를 세션에 보관할 때 사용

@NoArgsConstructor
@Getter
public class AuthInfo {
	private String memberEmail;
	private String memberName;
	private String memberPass;
	
	public AuthInfo(String memberEmail,  String memberPass) {
		super();
		this.memberEmail = memberEmail;
		
		this.memberPass = memberPass;
	}
	  
	public AuthInfo(String memberEmail, String memberName, String memberPass) {
		super();
		this.memberEmail = memberEmail;
		this.memberName = memberName;
		this.memberPass = memberPass;
	}
}
