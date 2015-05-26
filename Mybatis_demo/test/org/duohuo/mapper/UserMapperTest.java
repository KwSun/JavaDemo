package org.duohuo.mapper;

import static org.junit.Assert.*;

import java.io.InputStream;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.duohuo.po.User;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UserMapperTest {

	private SqlSessionFactory sqlSessionFactory;

	// 在运行测试方法之前要执行
	@Before
	public void setUp() throws Exception {
		// 创建sqlSessionFactory会话工厂
		// mybatis的配置文件
		String resource = "SqlMapConfig.xml";

		InputStream inputStream = Resources.getResourceAsStream(resource);

		// 创建会话工厂
		sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindUserByUsername() throws Exception {
		
		//得到SqlSession
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		//通过 sqlSession得到UserMapper的动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper的方法
		User user = userMapper.findUserByUsername("kw");
		
		System.out.println(user);
	}
	@Test
	public void testFindUserList() throws Exception {
		
		//得到SqlSession
		SqlSession sqlSession  = sqlSessionFactory.openSession();
		//通过 sqlSession得到UserMapper的动态代理对象
		UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
		//调用userMapper的方法
		List<User> list = userMapper.findUserList();
		
		System.out.println(list.size());
	}

}
