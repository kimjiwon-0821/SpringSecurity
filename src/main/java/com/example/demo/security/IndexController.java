package com.example.demo.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.model.User;
import com.example.demo.model.UserDAO;

@Controller
public class IndexController {
	
	@Autowired
	private UserDAO userDAO;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@GetMapping("/")
	public String index() {
		return "index";
	}
	
	@GetMapping("user")
	public @ResponseBody String user() {
		return "user";
	}
	
	@GetMapping("admin")
	public @ResponseBody  String admin() {
		return "admin";
	}
	
	@GetMapping("manager")
	public @ResponseBody  String manager() {
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
	

	
	

}
