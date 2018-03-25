package com.san.dao;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.san.po.User;
public class UserDaoTest {
	private ApplicationContext cxt;
	@Before
	public void setUp() throws Exception {
		cxt = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		UserDao userDao = (UserDao) cxt.getBean("userDao");
		User user= userDao.findUserById(1);
		System.out.println(user);
	}

}
