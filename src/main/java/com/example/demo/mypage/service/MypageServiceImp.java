package com.example.demo.mypage.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.mypage.dto.DiaryDTO;
import com.example.demo.mypage.dto.EnterlistDTO;
import com.example.demo.mypage.entity.DiaryEntity;
import com.example.demo.mypage.entity.EnterlistEntity;
import com.example.demo.mypage.repository.DiaryRepository;
import com.example.demo.mypage.repository.EnterlistRepository;
import com.example.demo.mypage.repository.UserRepository;
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
	private DiaryRepository diaryRepository;
	
	@Autowired
	private EnterlistRepository enterlistRepository;
	
	public MypageServiceImp() {}
	
	@Override
	public UsersDTO userList(String email) {	
	UsersEntity result = usersRepository.findByEmail(email);
////		List<UsersEntity> result = userRepository.findByEmail(dto.getEmail());
//		
//		result.forEach(users -> aList.add(UsersDTO.toDTO(users)));	 
	
	    
	    
		return  UsersDTO.toDTO(result);
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

	@Override
	public List<DiaryDTO> diaryList(String email) {
		List<DiaryDTO> aList = new ArrayList<>();
		List<DiaryEntity> result = diaryRepository.findByEmail(email);
		
		result.forEach(diary -> aList.add(DiaryDTO.toDto(diary)));
		return aList;
	}

	@Override
	public void diaryWriteProcess(DiaryDTO dto) {
		

//		DiaryEntity entity = DiaryDTO.toEntity(dto);
		System.err.println("email:"+ dto.getUsersDTO().getEmail());
		diaryRepository.findDiarywrite(DiaryDTO.toEntity(dto) , dto.getUsersDTO().getEmail());
	}

	
	@Override
	public List<EnterlistDTO> enterList(String email) {
		List<EnterlistDTO> aList = new ArrayList<>();
		List<EnterlistEntity> result = enterlistRepository.findAll();
		result.forEach(enterlist -> aList.add(EnterlistDTO.toDto(enterlist)));
		return aList;
	}
	
	@Override
	public void insertEnterList(EnterlistDTO dto) {
		EnterlistEntity entity = EnterlistDTO.toEntity(dto);
		enterlistRepository.findSaveNew(entity.getInfoEntity().getInfoSeq());
	}
	
	@Override
	public void updateEnterList(EnterlistDTO dto) {
		EnterlistEntity entity = EnterlistDTO.toEntity(dto);
		enterlistRepository.findByUpdateEntity(entity);
	}
	
}