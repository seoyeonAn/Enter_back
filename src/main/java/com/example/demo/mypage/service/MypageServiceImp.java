package com.example.demo.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mypage.repository.UserRepository;
import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.UsersEntity;
import com.example.demo.users.repository.UsersRepository;


@Service
@Transactional
public class MypageServiceImp implements MypageService {
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UsersRepository usersRepository;
	
	public MypageServiceImp() {}
	
	@Override
	public List<UsersDTO> userList() {
		List<UsersDTO> aList = new ArrayList<>();
		List<UsersEntity> result = usersRepository.findAll();
//		List<UsersEntity> result = userRepository.findByEmail(dto.getEmail());
		
		result.forEach(users -> aList.add(UsersDTO.toDTO(users)));
		return aList;
	}

	@Override
	public UsersDTO updateUserProcess(String email) {
		UsersEntity userEntity = usersRepository.findByEmail(email);
		return UsersDTO.toDTO(userEntity);
	}

	@Override
	public AuthInfo updateUserProcess(UsersDTO dto) {
		System.out.println("email:"+ dto.getEmail());
		UsersEntity entity = UsersDTO.toEntity(dto);
		usersRepository.save(entity);
		return new AuthInfo(dto.getEmail(), dto.getName(), dto.getPassword());
	}


}
