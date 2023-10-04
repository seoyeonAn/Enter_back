package com.example.demo.info.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enter.dto.EnterDTO;
import com.example.demo.info.dao.InfoDAO;
import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;
import com.example.demo.info.entity.InfoEntity;
import com.example.demo.info.repository.InfoRepository;
import com.example.demo.mypage.dto.EnterlistDTO;
import com.example.demo.mypage.entity.EnterlistEntity;
import com.example.demo.mypage.repository.EnterlistRepository;

@Service
@Transactional
public class InfoServiceImp implements InfoService{
	@Autowired
	private InfoRepository infoRepository;
	
	@Autowired
	private EnterlistRepository enterlistRepository;
	
	public InfoServiceImp() {}
	
	@Override
//	public long countProcess() {
//		return infoRepository.findCount();
//	}
	public long countProcess(String searchKey, String searchWord) {
		Map<String, String> search = new HashMap<String, String>();
		search.put("searchKey", searchKey);
		search.put("searchWord", searchWord);
		//return infoRepository.countByCategoryAndTitle(search);
		return infoRepository.countByCategoryAndTitle(searchKey, searchWord);
	}	

	@Override
	public List<InfoDTO> listProcess(PageDTO pv) {
		List<InfoDTO> aList = new ArrayList<>();
		//List<InfoEntity> result = infoRepository.findAllActiveInformationNative(pv.getStartRow(), pv.getEndRow());
		List<InfoEntity> result = infoRepository.findAllActiveInformationNative(pv.getStartRow(), pv.getEndRow(),pv.getSearchKey(), pv.getSearchWord());
		result.forEach(information -> aList.add(InfoDTO.toDto(information)));
		return aList;
	}
	
	@Override
	public InfoDTO contentProcess(long infoSeq) {
		InfoDTO iDTO =InfoDTO.toDto(infoRepository.findByContent(infoSeq));
		return iDTO;
	}
	
	@Override
	public void insertEnterList(EnterlistDTO dto) {
		EnterlistEntity entity = EnterlistDTO.toEntity(dto);
		enterlistRepository.findSaveNew(entity.getInfoEntity().getInfoSeq());
	}
	
}
