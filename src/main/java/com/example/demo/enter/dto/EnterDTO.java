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
@Component
public class EnterDTO {
	private long enterSeq;
    private long completed;

    private InfoDTO infoDTO = new InfoDTO();
	
	public static EnterDTO toDto(EnterEntity entity) {
		InfoDTO infoDTO = new InfoDTO();
		infoDTO.setInfoSeq(entity.getInfoEntity().getInfoSeq());
		infoDTO.setTitle(entity.getInfoEntity().getTitle());
		
		return EnterDTO.builder()
				.enterSeq(entity.getEnterSeq())
				.completed(entity.getCompleted())
				.infoDTO(infoDTO)
				.build();		
	}
	
	public static EnterEntity toEntity(EnterDTO dto) {
		InfoEntity infoEntity = new InfoEntity();
		infoEntity.setInfoSeq(dto.getInfoDTO().getInfoSeq());
		infoEntity.setTitle(dto.getInfoDTO().getTitle());
		
		return EnterEntity.builder()
				.enterSeq(dto.getEnterSeq())
				.completed(dto.getCompleted())
				.infoEntity(infoEntity)
				.build();
	}
}
