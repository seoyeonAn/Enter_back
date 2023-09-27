package com.example.demo.enter.entity;

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
public class EnterEntity {
	@Id
	@Column(name="enter_seq", insertable = false)
	private long enterSeq;
	
	@Column
	private long completed;	
	
	@ManyToOne
	@JoinColumn(name="info_seq")
	private InfoEntity infoEntity= new InfoEntity();

	
}
