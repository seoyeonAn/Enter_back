package com.example.demo.enter.dto;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.springframework.stereotype.Component;

import com.example.demo.enter.entity.EnterEntity;
import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.entity.InfoEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Builder
//@Component
public class EnterDTO {
	@Id
	@Column(insertable = false)
	private long enter_seq;
	
	@Column(insertable = false)
    private long completed;
	
	@Column(name="info_seq")
    private long info_seq;
	
//	@ManyToOne
//	@JoinColumn(name="title")
//	private InfoEntity infoEntity;
 

	@Column(insertable = false)
    private String title;
//  private InfoDTO infoDTO;
	
	public static EnterDTO toDto(EnterEntity entity) {
		return EnterDTO.builder()
				.enter_seq(entity.getEnter_seq())
				.completed(entity.getCompleted())
				.info_seq(entity.getInfo_seq())
				.title(entity.getTitle())
				.build();		
	}
	
	public static EnterEntity toEntity(EnterDTO dto) {
		return EnterEntity.builder()
				.enter_seq(dto.getEnter_seq())
				.completed(dto.getCompleted())
				.info_seq(dto.getInfo_seq())
				.title(dto.getTitle())
				.build();
	}
}
