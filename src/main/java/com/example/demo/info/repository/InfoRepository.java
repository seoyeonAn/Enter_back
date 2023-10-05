package com.example.demo.info.repository;

import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.info.entity.InfoEntity;

import java.util.List;



public interface InfoRepository extends JpaRepository<InfoEntity, Long>{
	@Query(value="SELECT count(*) FROM information WHERE category LIKE '%'||"
			+ ":#{#seachKey}"
			+ "||'%'"
			+ " AND title LIKE '%'||"
			+ ":#{#searchWord}" + "||'%'"
			, nativeQuery=true)
	long countByCategoryAndTitle(@Param("seachKey") String seachKey, @Param("searchWord") String searchWord);
	//long countByCategoryAndTitle(@Param("search") Map<String, String> search);


	@Query(value="SELECT b.* FROM (SELECT rownum AS rm, a.* FROM(SELECT i.* FROM information i)a"
			+ " WHERE category LIKE '%'||"
			+ ":#{#seachKey}"
		    + "||'%'"
			+ " AND title LIKE '%'||"
			+ ":#{#searchWord}"
			+ "||'%')b"
			+ " WHERE b.rm>=:startRow AND b.rm<=:endRow"
			+ " ORDER BY b.info_seq"
		, nativeQuery=true)
	List<InfoEntity> findAllActiveInformationNative(@Param("startRow") long startRow, @Param("endRow") long endRow,
			@Param("seachKey") String seachKey,
			@Param("searchWord") String searchWord);


	@Query(value="SELECT * FROM information WHERE info_seq = :infoSeq", nativeQuery=true)
	InfoEntity findByContent(@Param("infoSeq") long infoSeq);
}
