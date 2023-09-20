package com.Users.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.Users.dto.UsersDTO;

@Mapper
@Repository
public interface UsersDAO {
	public int insertUsers(UsersDAO dto);
	public UsersDTO selectByEmail(String memberEmail);	
	public void updateMember(UsersDTO dto);
	public void updateByPass(UsersDTO dto);
}
