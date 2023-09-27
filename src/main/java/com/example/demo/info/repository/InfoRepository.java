package com.example.demo.info.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.demo.info.entity.InfoEntity;

import java.util.List;

@Repository
public interface InfoRepository extends JpaRepository<InfoEntity, Long>{
	@Query(value="SELECT count(*) FROM information", nativeQuery=true)
	long findCount();
	
	@Query(value="SELECT b.* FROM (SELECT rownum AS rm, a.* FROM(SELECT i.*"
		    + " FROM information i)a)b"	   
		    + " WHERE b.rm>=:startRow AND b.rm<=:endRow"
//		    + " ORDER BY b.infoSeq"
		, nativeQuery=true )
	List<InfoEntity> findAllActiveInformationNative(@Param("startRow") long startRow, @Param("endRow") long endRow);
	

	@Query(value="SELECT * FROM information WHERE infoSeq=:infoSeq", nativeQuery=true)
//	@Query(value="SELECT e.enterSeq, i.* FROM information i, enterlist e"
//			+ " WHERE i.infoSeq = e.infoSeq(+)"
//			+ " AND i.infoSeq = :infoSeq", nativeQuery=true)
	InfoEntity findByContent(@Param("infoSeq") long infoSeq);
}
