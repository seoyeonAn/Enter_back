package com.example.demo.users.service;

import com.example.demo.users.dto.AuthInfo;
import com.example.demo.users.dto.UsersDTO;

public interface UsersService {
	public AuthInfo addUsersProcess(UsersDTO dto);
	public AuthInfo loginProcess(UsersDTO dto);
}//end class
