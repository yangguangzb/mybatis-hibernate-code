package com.san.test;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import com.san.mapper.OrdersMapper;
import com.san.po.OrdersExt;
public class Test {
	//懒加载
	@org.junit.Test
	public void Test01() throws IOException{
		// 读取配置文件
		// 全局配置文件的路径
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		// 创建SqlSessionFactory
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		// 创建OrdersMapper对象
		SqlSession sqlSession = sqlSessionFactory.openSession();
		OrdersMapper mapper = sqlSession.getMapper(OrdersMapper.class);
		List<OrdersExt> list = mapper.findOrderAndUserLazyLoading();
		for (OrdersExt ordersExt : list) {
			System.out.println(ordersExt.getUser());
		}
		sqlSession.close();
	}
}
