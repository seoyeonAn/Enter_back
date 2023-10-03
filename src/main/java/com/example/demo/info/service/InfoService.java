package com.example.demo.info.service;

import java.util.List;

import com.example.demo.enter.dto.EnterDTO;
import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;

public interface InfoService {
	//public long countProcess();
	public long countProcess(String searchKey, String searchWord);
	public List<InfoDTO> listProcess(PageDTO pv);
	public InfoDTO contentProcess(long infoSeq);
}
