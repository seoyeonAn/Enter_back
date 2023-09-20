package com.Users.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="users")
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
/*

@NoArgsConstructor
파라미터가 없는 기본 생성자를 생성

@AllArgsConstructor
모든 필드 값을 파라미터로 받는 생성자를 만듦
 
-현재 members와 정확히 일치하는 칼럼들을 선언해줌
-private로 설정된 칼럼을 ID값으로 줌=@ID 

*/

public class UsersEntity {
	@Id
	@Column(name="users_email")
	private String usersEmail;
	
	@Column(name="users_password")
	private String usersPassword;
	
	@Column(name="users_name")
	private String usersName;
	
	@Column(name="users_phone")
	private long usersPhone;
	

}//end class
