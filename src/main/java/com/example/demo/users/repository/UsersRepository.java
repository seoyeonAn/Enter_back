package com.example.demo.users.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.users.entity.UsersEntity;

@Repository
public interface UsersRepository extends JpaRepository<UsersEntity, String>{
	/*Entity에 @Id값이 있는 데이터타입을 뒤에써줌  
	@Column(name="member_email")
	private String memberEmail;*/

//find+(엔티티명-생략가능)+BY+변수이름   
public UsersEntity findByEmail(String Email); 

}
