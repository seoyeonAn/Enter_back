package com.example.demo.enter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
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
	public void insertExcute(EnterDTO dto) {	
		System.out.println("info:" + dto.getInfo_seq());
		enterService.insert(dto);
	} 

	//@PutMapping("/enter/{enter_seq}/{completed}")
	//@PutMapping("/enter/update")
//	public void updateExcute(EnterDTO dto, int enter_seq, int completed) {
//		dto.setEnter_seq(enter_seq);
//		dto.setCompleted(completed==0?1:0);
//		enterService.update(dto);
//	}
	
//	public ResponseEntity<Object> putEnter(@PathVariable("enter_seq") int enter_seq, @PathVariable("completed") int completed) {
//		EnterDTO dto = new EnterDTO();
//		dto.setEnter_seq(enter_seq);
//		dto.setCompleted(completed==0?1:0);
//		enterService.update(dto);
//		return null;
//	}
	
//	@DeleteMapping("/enter/delete/{enter_seq}")
//	public void deleteExecute(@PathVariable("enter_seq")  long enter_seq) {		
//		enterService.delete(enter_seq);		
//	}
	
	
}
