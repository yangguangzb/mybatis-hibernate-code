package com.san.dao;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.san.po.User;

public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao {

	@Override
	public User findUserById(int id) {
		return this.getSqlSession().selectOne("test.findUserById",id);
	}
	
}
