package cn.microvideo.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.microvideo.domain.Classes;
import cn.microvideo.utils.MybatisUtil;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月23日 上午10:30:26 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Test5 {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.classMapper.getClass3";
		Classes c = sqlSession.selectOne(statement, 1);
		System.out.println(c);
		sqlSession.close();
	}
}
