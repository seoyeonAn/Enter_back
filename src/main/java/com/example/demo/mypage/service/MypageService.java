package com.example.demo.mypage.service;

import java.util.List;


import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;

public interface MypageService {
	public List<UsersDTO> userList();
	public UsersDTO updateMemberProcess(String memberEmail);
	public AuthInfo updateMemberProcess(UsersDTO dto);
}
