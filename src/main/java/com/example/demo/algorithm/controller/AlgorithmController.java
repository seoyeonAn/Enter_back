package com.example.demo.algorithm.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

//http://127.0.0.1:5000
@CrossOrigin("*")
@RestController
public class AlgorithmController {	
	@GetMapping("/")
    public String callFlaskFunction() {
		String flaskFunctionUrl = "http://127.0.0.1:5000";
        ResponseEntity<String> response = new RestTemplate().getForEntity(flaskFunctionUrl, String.class);
        String result = response.getBody();
        return result;
    }
}
