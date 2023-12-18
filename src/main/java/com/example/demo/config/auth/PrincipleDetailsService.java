package com.example.demo.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.demo.model.User;
import com.example.demo.model.UserDAO;

//시큐리티 설정에서 loginProcessingUrl("/login")
//login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어 있는 LoadUserByUsername 함수가 실행
@Service
public class PrincipleDetailsService implements UserDetailsService{

	@Autowired
	private UserDAO userDAO;
	
	//security session(내부 Authentication(내부 UserDetails))
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException { 
		// 여기 username이랑 dto의 username 이름이 같아야 security가 낚을 수 있음. 이름이 다르다면 security config 에서 이름을 수정해야 함.
		// TODO Auto-generated method stub
		User userEntity = userDAO.getUser(username); 
		if(userEntity!=null) {
			return new PrincipalDetails(userEntity);
		}
		return null;
	}

}
