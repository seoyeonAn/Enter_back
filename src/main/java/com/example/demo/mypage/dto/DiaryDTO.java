package com.example.demo.mypage.dto;

import java.sql.Date;

import org.springframework.stereotype.Component;

import com.example.demo.mypage.entity.DiaryEntity;
import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.UsersEntity;

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
	private String title, content, upload;
	private Date diary_date;
	
	private UsersDTO usersDTO =new UsersDTO();
	
	// diary
	public static DiaryDTO toDto(DiaryEntity entity) {
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setEmail(entity.getUsersEntity().getEmail());
	//	usersDTO.setName(entity.getUsersEntity().getName());
		return DiaryDTO.builder()
				.diary_seq(entity.getDiary_seq())
				.title(entity.getTitle())
				.content(entity.getContent())
				.upload(entity.getUpload())
				.diary_date(entity.getDiary_date())
//				.email(entity.getEmail())
				.usersDTO(usersDTO)
				.build();
	}
	
	public static DiaryEntity toEntity(DiaryDTO dto) {
		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setEmail(dto.getUsersDTO().getEmail());
		//usersEntity.setName(dto.getUsersDTO().getName());
		return DiaryEntity.builder()
				.diary_seq(dto.getDiary_seq())
				.title(dto.getTitle())
				.content(dto.getContent())
				.upload(dto.getUpload())
				.diary_date(dto.getDiary_date())
//				.email(dto.getEmail())
				.usersEntity(usersEntity)
				.build();
	}
}
