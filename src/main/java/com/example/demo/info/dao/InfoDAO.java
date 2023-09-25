package com.example.demo.info.dao;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import com.example.demo.enter.dto.EnterDTO;
import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;

@Mapper
@Repository
public interface InfoDAO {
	public int count();
	public List<InfoDTO> list(PageDTO pv);
	public InfoDTO content(int info_seq);
}
