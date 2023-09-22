package com.example.demo.mypage.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class MypageDTO {
	private String email, password, name, phone;
	private long diary_seq;
	private String title, content, upload;
	private Date diary_date;
}