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
//	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage, PageDTO pv) {
//		Map<String, Object> map = new HashMap<>();
//		long totalRecord = infoService.countProcess();
//		if(totalRecord>=1) {
//			  this.currentPage = currentPage;
//
//		   this.pdto = new PageDTO(this.currentPage, totalRecord);
//		  
//		   map.put("infoList", infoService.listProcess(this.pdto));
//		   map.put("pv", this.pdto);
//		}
//		return map;
//	}
	public Map<String, Object> listExecute(@PathVariable("currentPage") int currentPage,
			@RequestParam(defaultValue="") String searchKey,
			@RequestParam(defaultValue="") String searchWord, PageDTO pv) {
		Map<String, Object> map = new HashMap<>();
		System.out.println("searchKey : "+searchKey);//카테고리
		System.out.println("searchWord : "+searchWord);//검색어
		
		long totalRecord = infoService.countProcess(searchKey, searchWord);
		System.out.println("totalRecord : "+totalRecord);
		
		if(totalRecord>=1) {
			this.currentPage = currentPage;

			
		   this.pdto = new PageDTO(this.currentPage, totalRecord, searchKey, searchWord);

		   map.put("infoList", infoService.listProcess(this.pdto));
		   map.put("pv", this.pdto);
		}
		return map;
	}
	

	@GetMapping("/info/view/{infoSeq}")
	public InfoDTO viewExecute(@PathVariable("infoSeq") long infoSeq) {		
		 return  infoService.contentProcess(infoSeq);		
	}
}
