package com.example.demo.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import com.example.demo.model.User;

@Mapper
public interface UserMapper {
	@Insert("INSERT INTO USER VALUES(#{username},#{password},#{role})")
	public void insertUser(User user);
	
	@Select("SELECT * FROM USER WHERE USERNAME=#{username}")
	public User getUser(String username);

}
