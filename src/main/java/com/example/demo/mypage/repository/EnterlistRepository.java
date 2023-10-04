package com.example.demo.mypage.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.info.entity.InfoEntity;
import com.example.demo.mypage.entity.EnterlistEntity;

public interface EnterlistRepository extends JpaRepository<EnterlistEntity, Long>{
	@Query(value="SELECT e.*, i.title FROM enterlist e, information i"
			+ " WHERE e.info_seq= i.info_seq ORDER BY e.enter_seq DESC", nativeQuery=true)
	List<EnterlistEntity> findAll(@Param("entity") InfoEntity entity, @Param("title") String title);
	
	@Query(value="INSERT INTO enterlist VALUES (enterlist_seq.nextval,0,:infoSeq,:email)", nativeQuery=true)
	@Modifying
	void findSaveNew( @Param("infoSeq") Long infoSeq);
}