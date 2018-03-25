package com.san.mapper;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.san.po.User;

public class UserMapperTest {

	private ApplicationContext cxt;
	@Before
	public void setUp() throws Exception {
		cxt = new ClassPathXmlApplicationContext("spring/applicationContext.xml");
	}

	@Test
	public void testFindUserById() {
		UserMapper mapper = (UserMapper) cxt.getBean("userMapper");
		User user = mapper.findUserById(1);
		System.out.println(user);
	}

}
