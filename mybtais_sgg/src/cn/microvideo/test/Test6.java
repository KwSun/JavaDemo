package cn.microvideo.test;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import cn.microvideo.domain.Classes;
import cn.microvideo.domain.ConditionUser;
import cn.microvideo.domain.User;
import cn.microvideo.utils.MybatisUtil;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月23日 上午10:30:26 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public class Test6 {
	public static void main(String[] args) throws IOException {
		SqlSessionFactory sessionFactory = MybatisUtil.getFactory();
		SqlSession sqlSession = sessionFactory.openSession();
		String statement = "cn.microvideo.domain.userMapper2.getUser";
		String name = "o";
		name = null;
		ConditionUser parameter = new ConditionUser("%"+name+"%",13,18);
		List<User> list = sqlSession.selectList(statement, parameter);
		System.out.println(list);
		sqlSession.close();
	}
}
