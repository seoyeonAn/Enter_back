package com.example.demo.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.mypage.entity.DiaryEntity;


public interface DiaryRepository  extends JpaRepository<DiaryEntity, Long>{
	
	@Query(value= "select d.*, u.*"
			+ " from diary d, users u where d.email = u.email and u.email=:email"
			+ " order by diary_seq desc", nativeQuery=true)	
	public List<DiaryEntity> findByEmail(@Param("email") String email);
	
	@Query(value="INSERT INTO diary(diary_seq, title, content, diary_date, upload, email)"
			+ " VALUES(diary_seq.nextval,:#{#entity.title},:#{#entity.content}, sysdate, :#{#entity.upload},:email)", nativeQuery=true)
	@Modifying
	void findDiarywrite(@Param("entity") DiaryEntity entity, @Param("email") String email);
}
