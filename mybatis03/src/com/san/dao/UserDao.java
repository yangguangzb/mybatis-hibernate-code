package com.san.dao;

import com.san.po.User;

public interface UserDao {
	/**
	 * 根据用户ID查询用户信息
	 * @param id
	 * @return
	 */
	public User findUserById(int id);
}
