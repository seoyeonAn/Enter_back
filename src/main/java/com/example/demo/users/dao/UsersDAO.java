package com.example.demo.users.dao;


import org.springframework.stereotype.Repository;

import com.example.demo.users.dto.UsersDTO;


@Repository
public interface UsersDAO {
	public int insertUsers(UsersDAO dto);
	public UsersDTO selectByEmail(String memberEmail);
}
