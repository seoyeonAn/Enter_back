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


	@Query(value="SELECT b.* FROM (SELECT rownum AS rm, a.* FROM(SELECT i.* FROM information i  ORDER BY i.info_seq)a"
			+ " WHERE category LIKE '%'||"
			+ ":#{#seachKey}"
		    + "||'%'"
			+ " AND title LIKE '%'||"
			+ ":#{#searchWord}"
			+ "||'%')b"
			+ " WHERE b.rm>=:startRow AND b.rm<=:endRow"
		, nativeQuery=true)
	List<InfoEntity> findAllActiveInformationNative(@Param("startRow") long startRow, @Param("endRow") long endRow,
			@Param("seachKey") String seachKey,
			@Param("searchWord") String searchWord);


	@Query(value="SELECT * FROM information WHERE info_seq = :infoSeq", nativeQuery=true)
	InfoEntity findByContent(@Param("infoSeq") long infoSeq);
	
	@Query(value="SELECT *"
			+ "FROM ("
			+ "    SELECT *"
			+ "    FROM information"
			+ "    WHERE category = 'exhibition'"
			+ "    ORDER BY dbms_random.value"
			+ ")"
			+ "WHERE ROWNUM <= 4"
		, nativeQuery=true)
	List<InfoEntity> findAllexhibitionList();
	
	@Query(value="SELECT *"
			+ "FROM ("
			+ "    SELECT *"
			+ "    FROM information"
			+ "    WHERE category = 'show'"
			+ "    ORDER BY dbms_random.value"
			+ ")"
			+ "WHERE ROWNUM <= 4"
		, nativeQuery=true)
	List<InfoEntity> findAllshowList();
	
	@Query(value="SELECT *"
			+ "FROM ("
			+ "    SELECT *"
			+ "    FROM information"
			+ "    WHERE category = 'museum'"
			+ "    ORDER BY dbms_random.value"
			+ ")"
			+ "WHERE ROWNUM <= 4"
		, nativeQuery=true)
	List<InfoEntity> findAllmuseumList();
}
