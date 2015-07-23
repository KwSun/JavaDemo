package cn.microvideo.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.microvideo.domain.Classes;
import cn.microvideo.domain.Order;
import cn.microvideo.utils.MybatisUtil;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午10:51:27 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Test4 {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.classMapper.getClass2";
		Classes c = sqlSession.selectOne(statement, 2);
		System.out.println(c);
		sqlSession.close();
	}
}
