package com.example.demo.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mypage.service.MypageService;
import com.example.demo.users.dto.UsersDTO;

import oracle.jdbc.proxy.annotation.Post;

@CrossOrigin("*")
@RestController
public class MypageController {
	@Autowired 
	private MypageService mypageService;
	
	public MypageController() {}
	
	@GetMapping("/mypage") 
	public Map<String, Object> userList(){
		System.out.println("test");
		Map<String, Object> map = new HashMap<>();
		
		map.put("userList", mypageService.userList());

		return map;
	}
	
	@PostMapping("/mypage")
	public void updateUser(@RequestBody UsersDTO usersDTO) {
//		UsersDTO.setPassword(encodePassword.encode(usersDTO.getPassword()));
		System.out.println("controller email:"+ usersDTO.getEmail());
		mypageService.updateUserProcess(usersDTO);		
	}
	
	
}
