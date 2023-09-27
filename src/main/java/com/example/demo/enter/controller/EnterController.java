package com.example.demo.enter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	public Map<String, Object> getList(){
		Map<String, Object> map = new HashMap<>();
		map.put("enterList", enterService.enterList());
		return map;
	}

	@PostMapping("/info/view")
	public void insertExcute(EnterDTO dto, long infoSeq) {		
		dto.getInfoDTO().setInfoSeq(infoSeq);		
		enterService.insert(dto);
	} 
	
//	@PutMapping("/enter")
//	public ResponseEntity<Object> updateExcute(@PathVariable("enterSeq") long enterSeq, @PathVariable("completed") long completed){
//		EnterDTO dto = new EnterDTO();
//		dto.setEnterSeq(enterSeq);
//		dto.setCompleted(completed==0?1:0);
//		enterService.update(dto);
//		return null;
//	}
	
//	public void updateExcute(@PathVariable("enterSeq") long enterSeq, @PathVariable("completed") long completed){
//		EnterDTO dto = new EnterDTO();
//		dto.setEnterSeq(enterSeq);
//		dto.setCompleted(completed==0?1:0);
//		enterService.update(dto);
//	}
	
}
