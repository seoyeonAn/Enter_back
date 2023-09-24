package com.example.demo.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mypage.dao.MypageDAO;
import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.UsersEntity;
import com.example.demo.users.repository.UsersRepository;


@Service
@Transactional
public class MypageServiceImp implements MypageService {
	@Autowired
	private UsersRepository usersRepository;
	
	@Autowired
	private MypageDAO mypageDao;
	
//	@Override
//	public List<UsersDTO> userList() {
//		List<UsersDTO> aList = new ArrayList<>();
//		List<UsersEntity> result = usersRepository.findAll();
//		
//		result.forEach(users -> aList.add(UsersDTO.toDTO(users)));
//		return aList;
//	}
	
	@Override
	public List<UsersDTO> userList() {
		return mypageDao.userList();
	}

	@Override
	public UsersDTO updateMemberProcess(String email) {
		UsersEntity userEntity = usersRepository.findByEmail(email);
		return UsersDTO.toDTO(userEntity);
	}

	@Override
	public AuthInfo updateMemberProcess(UsersDTO dto) {
		// TODO Auto-generated method stub
		return null;
	}


}
