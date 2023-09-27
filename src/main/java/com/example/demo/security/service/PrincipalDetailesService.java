package com.example.demo.security.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.users.dto.UsersDTO;
import com.example.demo.users.entity.UsersEntity;
import com.example.demo.users.repository.UsersRepository;

@Service
public class PrincipalDetailesService  implements UserDetailsService{
	
	@Autowired
	private UsersRepository userRerepository;
	
	public PrincipalDetailesService() {
		
	}
 
	
	//1. AuthenticationProvider에서 loadUserByUsername(String username)을 호출한다.
	//2. loadUserByUsername(String username)에서는 DB에서 username에 해당하는 데이터를 검색해서 UserDetails에 담아서 리턴해준다.
	//3. AuthenticationProvider에서 UserDetailes받아서 Authentication에 저장을 함으로써 결국 Security Session에 저장을 한다.
		
	@Override
	public UserDetails loadUserByUsername(String Email) throws UsernameNotFoundException {
		//System.out.println("loadUserByUsername:" + memberEmail);		
		UsersEntity userEntity = userRerepository.findByEmail(Email); //findbyemail로 처리하면 자동으로 option으로 처리됨
	
//		Optional<MembersEntity> opt = memRepository.findById(memberEmail);		
//		MembersEntity userEntity = opt.get();
		
		
		if(userEntity == null) {
			throw new UsernameNotFoundException(Email);
		}
	
		
		return new PrincipalDetails(UsersDTO.toDTO(userEntity));
	}   
	
}








