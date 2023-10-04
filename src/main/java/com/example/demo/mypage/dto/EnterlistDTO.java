package com.example.demo.mypage.dto;


import org.springframework.stereotype.Component;
import com.example.demo.mypage.entity.EnterlistEntity;
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
	private long enter_seq, info_seq, completed;
	private String email;
	
	
	// enter list
	public static EnterlistDTO toDto(EnterlistEntity entity) {
		return EnterlistDTO.builder()
				.enter_seq(entity.getEnter_seq())
				.completed(entity.getCompleted())
				.info_seq(entity.getInfo_seq())
				.email(entity.getEmail())
				.build();
	}
	
	public static EnterlistEntity toEntity(EnterlistDTO dto) {
		return EnterlistEntity.builder()
				.enter_seq(dto.getEnter_seq())
				.completed(dto.getCompleted())
				.info_seq(dto.getInfo_seq())
				.email(dto.getEmail())
				.build();
	}

}