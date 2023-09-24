package com.example.demo.mypage.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.mypage.service.MypageService;

@CrossOrigin("*")
@RestController
public class MypageController {
	@Autowired MypageService mypageService;
	
	public MypageController() {}
	
	@GetMapping("/mypage")
	public Map<String, Object> userList(){
		Map<String, Object> map = new HashMap<>();
		
		map.put("userList", mypageService.userList());
		System.out.println(map);
		return map;
	}
}
