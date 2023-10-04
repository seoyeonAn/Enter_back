package com.example.demo.mypage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mypage.dto.DiaryDTO;
import com.example.demo.mypage.service.MypageService;
import com.example.demo.users.dto.UsersDTO;

import oracle.jdbc.proxy.annotation.Post;

@CrossOrigin("*")
@RestController
public class MypageController {
	@Autowired 
	private MypageService mypageService;
	
	public MypageController() {}
	
	@GetMapping("/mypage/{email}") 
	public Map<String, Object> mypageList(@PathVariable("email") String email){
		System.out.println("test:" + email );
		Map<String, Object> map = new HashMap<>();
		
		map.put("userList", mypageService.userList(email));
		map.put("diaryList", mypageService.diaryList(email));
		return map;
	}
	
	@PostMapping("/mypage/updateuser")
	public void updateUser(@RequestBody UsersDTO usersDTO) {
//		UsersDTO.setPassword(encodePassword.encode(usersDTO.getPassword()));
		
		mypageService.updateUserProcess(usersDTO);		
	}
	
	@PostMapping("/mypage/diarywrite")
	public void diaryWrite( DiaryDTO diaryDTO, String email) {		
		diaryDTO.getUsersDTO().setEmail(email);
		mypageService.diaryWriteProcess(diaryDTO);		
	}
	
}