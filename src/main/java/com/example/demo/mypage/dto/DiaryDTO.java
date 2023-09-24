package com.example.demo.mypage.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.demo.mypage.entity.DiaryEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DiaryDTO {
	private long diary_seq;
	private String title, content, upload, email;
	private Date diary_date;
	
	// diary
	public static DiaryDTO toDto(DiaryEntity entity) {
		return DiaryDTO.builder()
				.diary_seq(entity.getDiary_seq())
				.title(entity.getTitle())
				.content(entity.getContent())
				.upload(entity.getUpload())
				.email(entity.getEmail())
				.build();
	}
	
	public static DiaryEntity toEntity(DiaryDTO dto) {
		return DiaryEntity.builder()
				.diary_seq(dto.getDiary_seq())
				.title(dto.getTitle())
				.content(dto.getContent())
				.upload(dto.getUpload())
				.email(dto.getEmail())
				.build();
	}
}
