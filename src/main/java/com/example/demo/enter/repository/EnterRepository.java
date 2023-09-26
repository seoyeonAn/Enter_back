package com.example.demo.enter.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.enter.entity.EnterEntity;

@Repository
public interface EnterRepository  extends JpaRepository<EnterEntity, Long>{
	@Query(value="SELECT e.*, i.title FROM enterlist e, information i WHERE e.info_seq=i.info_seq order by enter_seq desc", nativeQuery=true)
	List<EnterEntity> findAll();
	
	@Query(value="INSERT INTO enterlist VALUES (enterlist_seq.nextval,0,:#{#entity.info_seq},'aa@aaa.com')", nativeQuery=true)
	@Modifying
	void findSaveNew(@Param("entity") EnterEntity entity);
	
//	@Query(value="UPDATE enterlist SET completed=:completed WHERE enter_seq=:enter_seq", nativeQuery=true)
//	@Query(value="UPDATE enterlist SET completed=:#{#completed} WHERE enter_seq=:#{#enter_seq}", nativeQuery=true)
//	@Modifying
//	void findByUpdateEntity(@Param("entity") EnterEntity entity);
	
//	@Query(value="DELETE FROM enterlist WHERE enter_seq=:enter_seq" , nativeQuery=true)
//	@Modifying
//	void findDelete(@Param("enter_seq") long enter_seq);
}
