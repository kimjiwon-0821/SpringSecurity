package com.example.demo.config.auth;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.example.demo.model.User;

//시큐리티가 login 주소 요청이 오면 낚아채서 로그인을 진행시킨다.
//로그인 진행이 완료가 되면 시큐리티 session을 만들어줍니다. (security contextHoler - > 키갑ㄱ에 세션 값을 저장한다.)
//오브젝트 타입 => Authentication 타입 객체여야 함.
//Authentication 안에 User 정보가 있어야 함.
// User 오브젝트 타입 => UserDetails 탕비 객체

//Security Session => Authentication => UserDetails
public class PrincipalDetails implements UserDetails {
	
	private User user;
	
	public PrincipalDetails(User user) {
		this.user = user;
	}

	//해당 User의 권한을 리턴하는 곳
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add(new GrantedAuthority() {
			
			@Override
			public String getAuthority() {
				return user.getRole();
			}
		});
		return collect;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return user.getUsername();
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

}
