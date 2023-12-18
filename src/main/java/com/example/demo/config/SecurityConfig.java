package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity // 활성화하면 spring security filter(security config)가 spring fillterchain으로 등록됨.
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	
	@Bean
	public BCryptPasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}
	
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable();
		http.authorizeRequests()
			.antMatchers("/user/**").authenticated()
			.antMatchers("/manager/**").access("hasRole('ROLE_ADMIN')OR hasRole('ROLE_MANAGER')")
			.antMatchers("/admin/**").access("hasRole('ROLE_ADMIN')")
			.anyRequest().permitAll()
			.and()
			.formLogin()
			.loginPage("/loginForm")
			.loginProcessingUrl("/login") // login 주소가 호출이 되면 시큐리티가 낚아채서 대신 로그인을 진행줍니다.
			.defaultSuccessUrl("/");
	}
	

}
