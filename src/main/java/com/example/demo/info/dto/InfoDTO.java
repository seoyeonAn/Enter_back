package com.example.demo.info.dto;

import java.sql.Date;

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
public class InfoDTO {
	private int info_seq;
	private String title, content, place, category, price, thumbnail, tel, homepage;
	private Date start_date, end_date;
}
