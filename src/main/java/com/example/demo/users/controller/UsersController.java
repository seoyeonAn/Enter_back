package com.example.demo.users.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.BadRequestException;
import com.example.demo.users.service.UsersService;


//@CrossOrigin 어노테이션을 붙여주면 기본적으로 '모든 도메인, 모든 요청방식' 에 대해 허용
@CrossOrigin("*")
@RestController
public class UsersController {
	public UsersController() {   }//생성자
	
	@Autowired
	private UsersService usersService;
	
	@Autowired
   private BCryptPasswordEncoder encodePassword;
	
	// http://localhost:8090/join
//회원가입 처리
	@PostMapping("/join")
	public String addMember(@RequestBody UsersDTO usersDTO) {		
//			UsersDTO.setUsersPassword(encodePassword.encode(UsersDTO.getUsersPassword()));
		usersDTO.setPassword(encodePassword.encode(usersDTO.getPassword()));
         System.out.println(usersDTO.getEmail());
		AuthInfo authInfo = usersService.addUsersProcess(usersDTO);		
		return null;
	}
 
//회원가입 시 이메일 유효성검사	
	@GetMapping("/users/email")		
	public  long checkIdDuplication(@RequestParam(value="email") String email) throws BadRequestException{
		System.out.println(email);
		if(usersService.existsByEmail(email)) {
			    return 0;
			}else {
				return 1;
			}
	}
		
	
}//end class
