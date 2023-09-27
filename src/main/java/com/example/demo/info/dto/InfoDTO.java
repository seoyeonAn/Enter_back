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
	private long infoSeq;
	private String title, content, place, category, price, thumbnail, tel, homepage, tag;
	private Date startDate, endDate;
	
	public static InfoDTO toDto(InfoEntity entity) {
		return InfoDTO.builder()
				.infoSeq(entity.getInfoSeq())
				.title(entity.getTitle())
				.content(entity.getContent())		
				.place(entity.getPlace())
				.category(entity.getCategory())
				.price(entity.getPrice())
				.thumbnail(entity.getThumbnail())
				.tel(entity.getTel())
				.homepage(entity.getHomepage())
				.startDate(entity.getStartDate())
				.endDate(entity.getEndDate())
				.tag(entity.getTag())
				.build();
	}
	
	public static InfoEntity toEntity(InfoDTO dto) {
		return InfoEntity.builder()
				.infoSeq(dto.getInfoSeq())
				.title(dto.getTitle())
				.content(dto.getContent())		
				.place(dto.getPlace())
				.category(dto.getCategory())
				.price(dto.getPrice())
				.thumbnail(dto.getThumbnail())
				.tel(dto.getTel())
				.homepage(dto.getHomepage())
				.startDate(dto.getStartDate())
				.endDate(dto.getEndDate())
				.tag(dto.getTag())
				.build();
	}
}
