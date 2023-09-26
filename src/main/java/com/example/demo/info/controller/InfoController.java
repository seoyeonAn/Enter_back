package com.example.demo.info.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.dto.PageDTO;
import com.example.demo.info.service.InfoService;


@CrossOrigin("*")
@RestController
public class InfoController {
	@Autowired
	private InfoService infoService;
	
	@Autowired
	private PageDTO pdto;
	
	private int currentPage;
	
	public InfoController() {}
	
	// http://localhost:8090/info/1
	@GetMapping("/info/{currentPage}")
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, PageDTO pv) {
		Map<String, Object> map = new HashMap<>();
		long totalRecord = infoService.countProcess();
		if(totalRecord>=1) {
			  this.currentPage = currentPage;

		   this.pdto = new PageDTO(this.currentPage, totalRecord);
		  
		   map.put("infoList", infoService.listProcess(this.pdto));
		   map.put("pv", this.pdto);
		}
		return map;
	}

	
	// http://localhost:8090/info/view/1
	@GetMapping("/info/view/{info_seq}")
	public InfoDTO viewExecute(@PathVariable("info_seq") int info_seq) {	
		 return  infoService.contentProcess(info_seq);		
	}
}
