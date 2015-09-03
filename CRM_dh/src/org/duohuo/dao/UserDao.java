package org.duohuo.dao;

import java.util.List;
import java.util.Map;

import org.duohuo.entity.User;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年9月3日 下午3:11:15 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
/**
 * Dao接口
 * @author Kw
 *
 * Date: 2015年9月3日
 */
public interface UserDao {
	/**
	 * 用户登录
	 * @param user
	 * @return
	 */
	public User login(User user);
	
	/**
	 * 查询用户集合
	 * @param map
	 * @return
	 */
	public List<User> find(Map<String, Object> map);
	
	/**
	 * 获取总记录数
	 * @param map
	 * @return
	 */
	public Long getTotal(Map<String, Object> map);
	
}
