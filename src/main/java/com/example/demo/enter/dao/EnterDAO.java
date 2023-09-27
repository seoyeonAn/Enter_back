package com.example.demo.enter.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.enter.dto.EnterDTO;

@Mapper
@Repository
public interface EnterDAO {
	public List<EnterDTO> getEnterList();
	public int insertEnterList(EnterDTO dto);
	//public int updateEnterList(EnterDTO dto);
	//public int deleteEnterList(int enter_seq);
}
