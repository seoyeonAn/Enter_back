package com.example.demo.enter.dto;

import org.springframework.stereotype.Component;

import com.example.demo.info.dto.InfoDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
//@Component
public class EnterDTO {
	private int enter_seq, completed, info_seq;
	private String title;
	
	//private InfoDTO infoDTO;
}
