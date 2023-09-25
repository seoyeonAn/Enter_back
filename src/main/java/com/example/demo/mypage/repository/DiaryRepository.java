package com.example.demo.mypage.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.mypage.entity.DiaryEntity;

public interface DiaryRepository  extends JpaRepository<DiaryEntity, Long>{
	public DiaryEntity findByEmail(String email);
}
