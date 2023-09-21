package com.example.demo.users.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.UsersEntity;
import com.example.demo.users.repository.UsersResitory;

@Service
public class UsersServiceImp implements UsersService {
	public UsersServiceImp() { } //생성자
	
	@Autowired
	private UsersResitory usersRepository;
	
	@Override
	public AuthInfo addUsersProcess(UsersDTO dto) {
		//DTO를 entity로 바꿔줌 =>DTO에서 불러오기에 dto에 가서 entity로 바꾸는 작업 필요
		//Entity로 바꿔주기
		UsersEntity entity=UsersDTO.toEntity(dto);
		usersRepository.save(entity);
		return new AuthInfo(dto.getUsersEmail(), dto.getUsersName(), dto.getUsersPassword());
	}

	@Override
	public AuthInfo loginProcess(UsersDTO dto) {
		
		UsersEntity UsersEntity =  usersRepository.findByUsersEmail(dto.getUsersEmail());	
//		UsersDTO UsersDTO = UsersDTO.toDTO(UsersEntity);
//		
//		if(UsersEntity == null) {
//			//System.out.println("회원이 아닙니다.");
//			throw new WrongEmailPasswordException();
//		}
//		
//		if(!UsersDTO.matchPassword(dto.getUsersPassword())) {
//			//System.out.println("비밀번호가 다릅니다.");
//			throw new WrongEmailPasswordException();
//		}			
		
		return new AuthInfo(UsersEntity.getUsersEmail(), UsersEntity.getUsersName(), UsersEntity.getUsersPassword());
	}



}//end class