package com.example.demo.info.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

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
	
	public static InfoDTO toDto(InfoEntity entity) {
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
				.build();
	}
	
	public static InfoEntity toEntity(InfoDTO dto) {
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
				.build();
	}
}
