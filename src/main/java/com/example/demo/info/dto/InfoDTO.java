package com.example.demo.info.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.demo.enter.dto.EnterDTO;
import com.example.demo.enter.entity.EnterEntity;
import com.example.demo.info.entity.InfoEntity;

//import com.example.demo.info.entity.InfoEntity;

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
@Component
@Builder
public class InfoDTO {
	private long info_seq;
	private String title, content, place, category, price, thumbnail, tel, homepage, tag;
	private Date start_date, end_date;
	
	private EnterDTO enterDTO;
	
	public static InfoDTO toDto(InfoEntity entity) {
		EnterDTO enterDTO = new EnterDTO();
		//enterDTO.setEnter_seq(entity.getEnterEntity().getEnter_seq());	
		System.out.println("=============="+entity.getEnterEntity().getEnter_seq());
		if(entity.getEnterEntity()==null) {
			 enterDTO.setEnter_seq(0L);
		}else {
		   enterDTO.setEnter_seq(entity.getEnterEntity().getEnter_seq());
		}
		
		return InfoDTO.builder()
				.info_seq(entity.getInfo_seq())
				.title(entity.getTitle())
				.content(entity.getContent())		
				.place(entity.getPlace())
				.category(entity.getCategory())
				.price(entity.getPrice())
				.thumbnail(entity.getThumbnail())
				.tel(entity.getTel())
				.homepage(entity.getHomepage())
				.start_date(entity.getStart_date())
				.end_date(entity.getEnd_date())
				.tag(entity.getTag())
				.enterDTO(enterDTO)
				.build();
	}
	
	public static InfoEntity toEntity(InfoDTO dto) {
		EnterEntity enterEntity = new EnterEntity();
		enterEntity.setEnter_seq(dto.getEnterDTO().getEnter_seq());
		
		return InfoEntity.builder()
				.info_seq(dto.getInfo_seq())
				.title(dto.getTitle())
				.content(dto.getContent())		
				.place(dto.getPlace())
				.category(dto.getCategory())
				.price(dto.getPrice())
				.thumbnail(dto.getThumbnail())
				.tel(dto.getTel())
				.homepage(dto.getHomepage())
				.start_date(dto.getStart_date())
				.end_date(dto.getEnd_date())
				.tag(dto.getTag())
				.enterEntity(enterEntity)
				.build();
	}
}
