package com.san.mapper;
import com.san.po.User;

public interface UserMapper {
	// 1、 根据用户ID查询用户信息
	public User findUserById(int id) throws Exception;

	// 3、 添加用户
	public void insertUser(User user) throws Exception;
	
	//resultMap入门
	public User findUserRstMap(int id);
}
