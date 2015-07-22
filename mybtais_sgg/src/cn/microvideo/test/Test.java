package cn.microvideo.test;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import cn.microvideo.domain.User;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午3:52:10 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Test {
	public static void main(String[] args) throws IOException {
		String resource = "conf.xml";
		InputStream is = Resources.getResourceAsStream(resource);
		SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(is);
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.userMapper.getUser";
		User user = sqlSession.selectOne(statement, 1);
		System.out.println(user);
		
		
	}
}
