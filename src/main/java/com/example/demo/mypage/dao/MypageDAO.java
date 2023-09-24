package com.example.demo.mypage.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.users.dto.UsersDTO;

@Mapper
@Repository
public interface MypageDAO {
	public List<UsersDTO> userList();
}
