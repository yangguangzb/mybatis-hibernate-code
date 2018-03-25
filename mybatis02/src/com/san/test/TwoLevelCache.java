package com.san.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import com.san.mapper.UserMapper;
import com.san.po.User;

public class TwoLevelCache {
	@Test
	//二级缓存测试1
	public void Test01() throws Exception{
		String resource="SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		//由mybatis通过sqlSession来创建代理对象
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		
		//第一次查询
		User user1=mapper1.findUserById(1);
		System.out.println(user1);
		//在close的时候，才会将数据写入二级缓存中
		sqlSession1.close();
		
		//第二次查询
		User user2=mapper2.findUserById(1);
		System.out.println(user2);
		sqlSession2.close();
		
	}
	
	@Test
	//二级缓存测试2
	public void Test02() throws Exception{
		String resource="SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession1 = sqlSessionFactory.openSession();
		SqlSession sqlSession2 = sqlSessionFactory.openSession();
		SqlSession sqlSession3 = sqlSessionFactory.openSession();
		
		//由mybatis通过sqlSession来创建代理对象
		UserMapper mapper1 = sqlSession1.getMapper(UserMapper.class);
		UserMapper mapper2 = sqlSession2.getMapper(UserMapper.class);
		UserMapper mapper3 = sqlSession3.getMapper(UserMapper.class);
		
		//第一次查询
		User user1=mapper1.findUserById(1);
		System.out.println(user1);
		//在close的时候，才会将数据写入二级缓存中
		sqlSession1.close();
		
		//执行用户添加操作
		mapper3.insertUser(user1);
		//执行commit时，将一级缓存清空
		sqlSession3.close();
		
		
		//第二次查询
		User user2=mapper2.findUserById(1);
		//System.out.println(user2);
		sqlSession2.close();
	}
}
