package cn.microvideo.test;

import java.io.IOException;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.microvideo.domain.Order;
import cn.microvideo.utils.MybatisUtil;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午9:48:35 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Test3 {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.orderMapper.getOrder";
		Order order = sqlSession.selectOne(statement, 2);
		System.out.println(order);
	}
}
