package com.example.demo.enter.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
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
	
//	@PostMapping("/enter/insert")
//	public void insertExcute(@RequestBody EnterDTO dto) {	
//		enterService.insert(dto);
//	} 

	@PostMapping("/enter")
	public void insertExcute(@RequestBody EnterDTO dto) {	
		enterService.insert(dto);
	} 
	// http://localhost:8090/enter/1/0
//	@PutMapping("/enter/{enter_seq}/{completed}")
//	public ResponseEntity<Object> putEnter(@PathVariable("enter_seq") long enter_seq, @PathVariable("completed") long completed) throws Exception {
//		EnterDTO dto = new EnterDTO();
//		dto.setEnter_seq(enter_seq);
//		dto.setCompleted(completed==0?1:0);
//		enterService.update(dto);
//		return null;
//	}
	
	
}
