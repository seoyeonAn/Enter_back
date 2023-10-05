package com.example.demo.mypage.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.example.demo.info.entity.InfoEntity;
import com.example.demo.users.entity.UsersEntity;

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
	
//	@Column
//	private long info_seq;
	
//	@Column
//	private String email;
	
	@ManyToOne
	@JoinColumn(name="info_seq")
	private InfoEntity infoEntity= new InfoEntity();
	
	@ManyToOne
	@JoinColumn(name="email")
	private UsersEntity usersEntity= new UsersEntity();
}