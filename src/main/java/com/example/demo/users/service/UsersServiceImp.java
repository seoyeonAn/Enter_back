package com.example.demo.users.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.UsersEntity;
import com.example.demo.users.exception.WrongEmailPasswordException;
import com.example.demo.users.repository.UsersRepository;

@Service
public class UsersServiceImp implements UsersService {
	public UsersServiceImp() { } //생성자
	
	@Autowired
	private UsersRepository usersRepository;
	
//회원가입
	@Override
	public AuthInfo addUsersProcess(UsersDTO dto) {
		UsersEntity entity=UsersDTO.toEntity(dto);
		usersRepository.save(entity);
		return new AuthInfo(dto.getEmail(), dto.getName(), dto.getPassword());
	}
//회원가입 이메일 유효성검사
	/*Transactional:: 
	 * 데이터베이스를 다룰 때 트랜잭션을 적용하면 
	 * 데이터 추가, 갱신, 삭제 등으로 이루어진 작업을 처리하던 중 
	 * 오류가 발생했을 때 모든 작업들을 원상태로 되돌릴 수 있다. */
	@Transactional
	public boolean existsByEmail(String Email) {
		return usersRepository.existsByEmail(Email);
	}
	
		
//로그인
	@Override
	public AuthInfo loginProcess(UsersDTO dto) {
		
		UsersEntity UsersEntity =  usersRepository.findByEmail(dto.getEmail());	
		UsersDTO usersDTO = UsersDTO.toDTO(UsersEntity);
		
		if(UsersEntity == null) {
			System.out.println("회원이 아닙니다.");
			throw new WrongEmailPasswordException();
		}
		
		if(!usersDTO.matchPassword(dto.getPassword())) {
			System.out.println("비밀번호가 다릅니다.");
			throw new WrongEmailPasswordException();
		}			
		
		return new AuthInfo(UsersEntity.getEmail(), UsersEntity.getName(), UsersEntity.getPassword());
	}



}//end class