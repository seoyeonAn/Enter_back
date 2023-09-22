package com.example.demo.info.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.info.dao.InfoDAO;
import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;

@Service
public class InfoServiceImp implements InfoService{
	@Autowired
	private InfoDAO infoDao;
	
	public InfoServiceImp() {}
	
	@Override
	public int countProcess() {
		return infoDao.count();
	}

	@Override
	public List<InfoDTO> listProcess(PageDTO pv) {
		return infoDao.list(pv);
	}
	
	@Override
	public InfoDTO contentProcess(int info_seq) {
		return infoDao.content(info_seq);
	}
	
}
