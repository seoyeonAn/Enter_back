package com.example.demo.security.service;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import com.example.demo.users.dto.UsersDTO;


public class PrincipalDetails  implements UserDetails{
	
	private UsersDTO usersDTO;
	
    public PrincipalDetails() {
	  
    }
	
    public PrincipalDetails(UsersDTO uersDTO) {
    	this.usersDTO = usersDTO;  	  
    }

    
    public UsersDTO getUersDTO() {
    	return usersDTO;
    }
    
    
    // 권한 목록을 리턴
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		
		//객체생성(new array--)생성 후 권한에 따라 리턴
		Collection<GrantedAuthority> collect = new ArrayList<GrantedAuthority>();
		collect.add(new  GrantedAuthority() {
			@Override
			public String getAuthority() {
				//return membersDTO.getAuthRole();
				return "ROLE_USER";
			}			
		});		
		
		return collect;
	}

	@Override
	public String getPassword() {
		// 추후 서비스디테일로 넘어가 상속을 통해 usersDAO의 회원정보를 체크해 회원인지 확인
		return usersDTO.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return usersDTO.getEmail();
	}

	//계정만료여부 리턴 -  true(만료안됨)
	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정의 잠김여부 리턴- true(잠기지 않음)-휴면계정, error=>
	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	//비밀번호의 잠김여부 리턴- true(잠기지 않음) - 비밀번호 만료(3개월,6개월 후 변경요구)
	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	//계정의 활성화 여부 리턴 - true(활성화됨) - 이메일인증 시 무조건 활성화
	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}  
}
