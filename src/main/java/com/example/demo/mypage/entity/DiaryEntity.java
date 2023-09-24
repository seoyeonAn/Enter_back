package com.example.demo.mypage.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="diary")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryEntity {
	@Id
	@Column
	private long diary_seq;
	
	@Column
	private String title;
	
	@Column
	private String content;
	
	@Column
	private Date diary_date;
	
	@Column
	private String upload;
	
	@Column
	private String email;
}
