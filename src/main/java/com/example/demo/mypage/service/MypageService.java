package com.example.demo.mypage.service;

import java.util.List;

import com.example.demo.mypage.dto.DiaryDTO;
import com.example.demo.mypage.dto.EnterlistDTO;
import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;

public interface MypageService {
	public UsersDTO userList(String email);
	public UsersDTO updateUserProcess(String memberEmail);
	public AuthInfo updateUserProcess(UsersDTO dto);
	
	public List<DiaryDTO> diaryList(String email);
	public void diaryWriteProcess(DiaryDTO dto);
	
	public List<EnterlistDTO> enterList(String email);
	//public void insertEnterList(EnterlistDTO dto);
}