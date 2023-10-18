package com.example.demo.users.dto;

import com.example.demo.users.entity.UsersEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/*component:
	 * 일반적으로 자바 빈(Java Bean) 클래스에 사용되며, 
	 * 스프링의 의존성 주입(Dependency Injection) 및 관리 기능을 활용할 수 있게 합니다.*/


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
	private String email;
	private String password;
	private String name;
	private String phone;
	private boolean reusersEmail;
	
	
	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}
	
	
	//dto->entity
	public static UsersEntity toEntity(UsersDTO dto) {
		
		UsersEntity entity = new UsersEntity();
		entity.setEmail(dto.getEmail());
		entity.setPassword(dto.getPassword());
		entity.setName(dto.getName());
		entity.setPhone(dto.getPhone());
		return entity;
	}
	
	//entity->dto
	public static UsersDTO toDTO(UsersEntity entity) {
		UsersDTO dto = new UsersDTO();
		dto.setEmail(entity.getEmail());
		dto.setPassword(entity.getPassword());
		dto.setName(entity.getName());
		dto.setPhone(entity.getPhone());
		
		return dto;
	}
	
}//end class
