package com.example.demo.enter.service;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enter.dao.EnterDAO;
import com.example.demo.enter.dto.EnterDTO;
import com.example.demo.enter.entity.EnterEntity;
import com.example.demo.enter.repository.EnterRepository;

@Service
@Transactional
public class EnterServiceImp implements EnterService{
//	@Autowired
//	private EnterDAO enterDAO;
	
	@Autowired
	private EnterRepository enterRepository;
	
	public EnterServiceImp() {}
	
	@Override
	public List<EnterDTO> enterList() {
		List<EnterDTO> aList = new ArrayList<>();
		List<EnterEntity> result = enterRepository.findAll();
		result.forEach(enter -> aList.add(EnterDTO.toDto(enter)));
		return aList;
	}

	@Override
	public void insert(EnterDTO dto) {
		EnterEntity entity = EnterDTO.toEntity(dto);		
		enterRepository.findSaveNew(entity);
	}
	
//	@Override
//	public void update(EnterDTO dto) {
//		enterRepository.findByUpdateEntity(EnterDTO.toEntity(dto));
//	}
	
//	@Override
//	public void delete(long enter_seq) {
//		enterRepository.findDelete(enter_seq);
//	}

}
