package com.example.demo.info.service;

import java.util.List;

import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;

public interface InfoService {
	public int countProcess();
	public List<InfoDTO> listProcess(PageDTO pv);
}
