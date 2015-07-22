package cn.microvideo.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import cn.microvideo.domain.User;
import cn.microvideo.service.UserMapper;
import cn.microvideo.utils.MybatisUtil;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午4:10:09 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Test2 {
	@Test
	public void testAdd() throws IOException{
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.userMapper.addUser";
		int insert = sqlSession.insert(statement, new User(-1,"kw",23));
		sqlSession.commit();
		sqlSession.close();
		System.out.println(insert);
	}
	
	@Test
	public void testGetAll() throws IOException{
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.userMapper.getAllUsers";
		List<User> list = sqlSession.selectList(statement);
		sqlSession.close();
		System.out.println(list);
	}
	
	@Test
	public void testAdd2() throws IOException{
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession(true);
		UserMapper mapper = sqlSession.getMapper(UserMapper.class);
		int add = mapper.add(new User(-1,"lwq",25));
		System.out.println(add);
		sqlSession.close();
	}
}
