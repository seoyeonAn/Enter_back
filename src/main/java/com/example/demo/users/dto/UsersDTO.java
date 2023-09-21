package com.example.demo.users.dto;

import org.springframework.stereotype.Component;

import com.example.demo.users.entity.UsersEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

/*component:
	 * 일반적으로 자바 빈(Java Bean) 클래스에 사용되며, 
	 * 스프링의 의존성 주입(Dependency Injection) 및 관리 기능을 활용할 수 있게 합니다.*/


@Component
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UsersDTO {
	private String usersEmail;
	private String usersPassword;
	private String usersName;
	private String usersPhone;
//	private boolean rememberEmail; 자동로그인 할가?????
	
	//dto->entity
	public static UsersEntity toEntity(UsersDTO dto) {
		UsersEntity entity = new UsersEntity();
		entity.setUsersEmail(dto.getUsersEmail());
		entity.setUsersPassword(dto.getUsersPassword());
		entity.setUsersName(dto.getUsersName());
		entity.setUsersPhone(dto.getUsersPhone());
		return entity;
	}
	
	//entity->dto
	public static UsersDTO toDTO(UsersEntity entity) {
		UsersDTO dto = new UsersDTO();
		dto.setUsersEmail(entity.getUsersEmail());
		dto.setUsersPassword(entity.getUsersPassword());
		dto.setUsersName(entity.getUsersName());
		dto.setUsersPhone(entity.getUsersPhone());
		return dto;
	}
	
}//end class
