package com.example.demo.mypage.dto;

import org.springframework.stereotype.Component;

import com.example.demo.mypage.entity.UserEntity;

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
public class UserDTO {
	private String email, password, name, phone;
	
	// users
	public static UserDTO toDto(UserEntity entity) {
		return UserDTO.builder()
				.email(entity.getEmail())
				.password(entity.getPassword())
				.name(entity.getName())
				.phone(entity.getPhone())
				.build();		
	}
	

	public static UserEntity toEntity(UserDTO dto) {
		return UserEntity.builder()
				.email(dto.getEmail())
				.password(dto.getPassword())
				.name(dto.getName())
				.phone(dto.getPhone())
				.build();		
	}
	
}
