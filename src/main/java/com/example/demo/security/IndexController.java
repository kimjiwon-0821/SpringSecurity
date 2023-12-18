package com.example.demo.security;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.model.User;
import com.example.demo.model.UserDAO;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class IndexController {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public String index() {
		return "main";
	}
	
	@GetMapping("user")
	public String user() {
		return "user";
	}
	
	@GetMapping("admin")
	public String admin() {
		return "admin";
	}
	
	@GetMapping("manager")
	public String manager() {
		return "manager";
	}
	
	//spring security가 해당 주소를 낚아채버림. - SecurityConfig 파일 생성 후 작동안함.
	@GetMapping("loginForm")
	public String loginForm() {
		return "loginForm";
	}
	
	@GetMapping("joinForm")
	public String joinform() {
		return "joinForm";
	}
	
	@PostMapping("join")
	public String join(User user) {
		System.out.println(user);
		String rawPassword = user.getPassword();
		String encPassword = bCryptPasswordEncoder.encode(rawPassword);
		user.setPassword(encPassword);
		userDAO.insertUser(user);
		return "redirect:/loginForm";
	}
	

	@GetMapping("/info")
	public ModelAndView info(Principal principal,ModelAndView mv,User user) {
		user = userDAO.getUser(principal.getName());
		mv.addObject("info", user);
		mv.setViewName("info");
		return mv;
	}
	
	@PreAuthorize("hasRole('ROLE_MANAGER')or hasRole('ROLE_ADMIN')")
	@GetMapping("/data")
	public @ResponseBody String data() {
		return "데이터 정보";
	}
	
	@GetMapping("denied")
	public String AccessDenied() {
		return "denied";
	}
	

}
