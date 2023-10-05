package com.example.demo.info.service;

import java.util.List;
import java.util.Map;

import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;
import com.example.demo.mypage.dto.EnterlistDTO;

public interface InfoService {
	//public long countProcess();
	public long countProcess(String searchKey, String searchWord);
	//public long countProcess(Map<String, String> search);
	
	public List<InfoDTO> listProcess(PageDTO pv);
	
	public InfoDTO contentProcess(long infoSeq);
	
	public void insertEnterList(EnterlistDTO dto);
}
