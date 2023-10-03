package com.example.demo.mypage.dto;


import org.springframework.stereotype.Component;

import com.example.demo.info.dto.InfoDTO;
import com.example.demo.info.entity.InfoEntity;
import com.example.demo.mypage.entity.EnterlistEntity;
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
public class EnterlistDTO {
	//private long enter_seq, info_seq, completed;
	//private String email;
	
	private long enterSeq, completed;
	
	private InfoDTO infoDTO = new InfoDTO();
	private UsersDTO usersDTO = new UsersDTO();
	
	// enter list
	public static EnterlistDTO toDto(EnterlistEntity entity) {
		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setInfoSeq(entity.getInfoEntity().getInfoSeq());
		infoDTO.setTitle(entity.getInfoEntity().getTitle());
		
		
		UsersDTO usersDTO = new UsersDTO();
		usersDTO.setEmail(entity.getUsersEntity().getEmail());
		
		return EnterlistDTO.builder()
				//.enter_seq(entity.getEnter_seq())
				.enterSeq(entity.getEnterSeq())
				.completed(entity.getCompleted())
				//.info_seq(entity.getInfo_seq())
				//.email(entity.getEmail())
				.infoDTO(infoDTO)
				.usersDTO(usersDTO)
				.build();
	}
	
	public static EnterlistEntity toEntity(EnterlistDTO dto) {
		InfoEntity infoEntity = new InfoEntity();
		infoEntity.setInfoSeq(dto.getInfoDTO().getInfoSeq());
		infoEntity.setTitle(dto.getInfoDTO().getTitle());
		
		UsersEntity usersEntity = new UsersEntity();
		usersEntity.setEmail(dto.getUsersDTO().getEmail());
		
		return EnterlistEntity.builder()
				//.enter_seq(dto.getEnter_seq())
				.enterSeq(dto.getEnterSeq())
				.completed(dto.getCompleted())
				//.info_seq(dto.getInfo_seq())
				//.email(dto.getEmail())
				.infoEntity(infoEntity)
				.usersEntity(usersEntity)
				.build();
	}

}