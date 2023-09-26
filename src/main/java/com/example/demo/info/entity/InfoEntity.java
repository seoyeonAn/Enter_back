package com.example.demo.info.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.example.demo.enter.entity.EnterEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="information")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InfoEntity {
	@Id
	@Column
	private long info_seq;
	
	@Column
	private String title, content, place, category, price, thumbnail, tel, homepage, tag;
	
	@Column
	private Date start_date, end_date;
	
	@OneToOne
	//@ManyToOne
	@JoinColumn(name="info_seq")
	//@JoinColumn(name="enter_seq")
	private EnterEntity enterEntity;
}
