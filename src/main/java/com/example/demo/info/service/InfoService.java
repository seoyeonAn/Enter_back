package com.example.demo.info.service;

import java.util.List;
import java.util.Map;

import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;

public interface InfoService {
	public long countProcess(String searchKey, String searchWord);
	//public long countProcess(Map<String, String> search);
	
	public List<InfoDTO> listProcess(PageDTO pv);
	
	public InfoDTO contentProcess(long infoSeq);
	
	public List<InfoDTO> exhibitionListProcess();
	public List<InfoDTO> showListProcess();
	public List<InfoDTO> museumListProcess();
}
