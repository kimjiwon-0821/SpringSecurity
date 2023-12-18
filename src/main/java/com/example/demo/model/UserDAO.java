package com.example.demo.model;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class UserDAO {
	
	@Autowired
	private SqlSessionTemplate mybatis;
	
	public void insertUser(User user) {
		mybatis.insert("insertUser",user);
	}
	
	public User getUser(String username) {
		return mybatis.selectOne("getUser",username);
	}

}
