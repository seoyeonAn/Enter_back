package com.example.demo.info.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.info.dao.InfoDAO;
import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;
import com.example.demo.info.entity.InfoEntity;
import com.example.demo.info.repository.InfoRepository;

@Service
@Transactional
public class InfoServiceImp implements InfoService{
	@Autowired
	private InfoRepository infoRepository;
	
	public InfoServiceImp() {}
	
	@Override
	public long countProcess() {
		return infoRepository.findCount();
	}

	@Override
	public List<InfoDTO> listProcess(PageDTO pv) {
		List<InfoDTO> aList = new ArrayList<>();
		List<InfoEntity> result = infoRepository.findAllActiveInformationNative(pv.getStartRow(), pv.getEndRow());

		result.forEach(information -> aList.add(InfoDTO.toDto(information)));
		return aList;
	}
	
	@Override
	public InfoDTO contentProcess(long infoSeq) {
		InfoDTO iDTO =InfoDTO.toDto(infoRepository.findByContent(infoSeq));
		return iDTO;
	}
	
}
