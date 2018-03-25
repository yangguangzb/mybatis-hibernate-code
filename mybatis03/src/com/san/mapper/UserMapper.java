package com.san.mapper;

import com.san.po.User;

public interface UserMapper {
	/**
	 * 根据用户信息查询用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
}
