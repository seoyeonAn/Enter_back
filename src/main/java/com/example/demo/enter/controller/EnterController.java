package com.example.demo.enter.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.enter.dto.EnterDTO;
import com.example.demo.enter.service.EnterService;

@CrossOrigin("*")
@RestController
public class EnterController {
	@Autowired
	private EnterService enterService;
	
	public EnterController() {}
	
	// http://localhost:8090/enter
	@GetMapping("/enter")
	public List<EnterDTO> getList() throws Exception{
		return enterService.enterList();
	}
	
	// http://localhost:8090/enter/1/0
	@PutMapping("/enter/{enter_seq}/{completed}")
	public ResponseEntity<Object> putEnter(@PathVariable("enter_seq") int enter_seq, @PathVariable("completed") int completed) throws Exception {
		EnterDTO dto = new EnterDTO();
		dto.setEnter_seq(enter_seq);
		dto.setCompleted(completed==0?1:0);
		enterService.update(dto);
		return null;
	}
	
	
}
