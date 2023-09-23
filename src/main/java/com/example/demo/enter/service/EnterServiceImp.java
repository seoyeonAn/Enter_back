package com.example.demo.enter.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.enter.dao.EnterDAO;
import com.example.demo.enter.dto.EnterDTO;

@Service
public class EnterServiceImp implements EnterService{
	@Autowired
	private EnterDAO enterDAO;
	
	public EnterServiceImp() {}
	
	@Override
	public List<EnterDTO> enterList() {
		return enterDAO.getEnterList();
	}

	@Override
	public int update(EnterDTO dto) {
		return enterDAO.updateEnterList(dto);
	}

}
