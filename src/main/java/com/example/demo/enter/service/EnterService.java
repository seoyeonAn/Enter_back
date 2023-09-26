package com.example.demo.enter.service;

import java.util.List;

import com.example.demo.enter.dto.EnterDTO;

public interface EnterService {
	public List<EnterDTO> enterList();
	public void insert(EnterDTO dto);
	//public void update(EnterDTO dto);
	//public void delete(long enter_seq);
}
