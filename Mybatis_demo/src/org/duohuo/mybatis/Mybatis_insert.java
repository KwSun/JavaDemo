package org.duohuo.mybatis;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.duohuo.po.User;

public class Mybatis_insert {
	public static void main(String[] args) throws IOException {
		//获取配置文件
		String resource = "SqlMapConfig.xml";
		InputStream inputStream = Resources.getResourceAsStream(resource);
		//创建会话工厂
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
		//获取SqlSession
		SqlSession sqlSession = sqlSessionFactory.openSession();
		//操作数据库
		User user = new User();
		user.setId(2);
		user.setUsername("fx");
		user.setSex("男");
		user.setAddress("安徽");
		sqlSession.insert("test.insertUser", user);
		//提交事务
		sqlSession.commit(); 
		//释放资源
		sqlSession.close();
	}
}
