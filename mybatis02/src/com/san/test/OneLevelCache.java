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
public class OneLevelCache {
	@Test
	//一级缓存测试1
	public void Test01() throws Exception{
		//全局配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建Mapper对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//第一次查询
		User user1=userMapper.findUserById(1);
		System.out.println(user1);
		//第二次查询
		User user2=userMapper.findUserById(1);
		System.out.println(user2);
		//关闭资源
		sqlSession.close();
	}
	
	@Test
	//一级缓存测试2
	public void Test02() throws Exception{
		//全局配置文件
		String resource="SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//创建mapper对象
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		//第一次查询
		User user1=mapper.findUserById(1);
		System.out.println(user1);
		
		//执行添加用户操作
		mapper.insertUser(user1);
		//执行commit操作，将一级缓存清空
		sqlSession.commit();
		
		//第二次查询
		User user2=mapper.findUserById(1);
		System.out.println(user2);
	}
}
