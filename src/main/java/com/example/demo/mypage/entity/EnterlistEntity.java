package com.example.demo.mypage.entity;

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
@Table(name="enterlist")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EnterlistEntity {
	@Id
	@Column
	private long enter_seq;
	
	@Column
	private long completed;
	
	@Column
	private long info_seq;
	
	@Column
	private String email;
}
