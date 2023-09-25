package com.example.demo.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.mypage.entity.UserEntity;
import com.example.demo.users.entity.UsersEntity;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, String> {
	public List<UsersEntity> findByEmail(String email);

}
 