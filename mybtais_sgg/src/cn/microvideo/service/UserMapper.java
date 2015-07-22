package cn.microvideo.service;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.microvideo.domain.User;

/** 
  * @author  作者：Kw
  * @date 创建时间：2015年7月22日 下午5:08:08 
  * @version 1.0 
  * @parameter  
  * @since  
  * @return  
  */
public interface UserMapper {
	
	@Insert("insert into users(name,age) values(#{name},#{age});")
	public int add(User user);
	
	@Delete("delete from users where id=#{id}")
	public int deleteById(User user);
	
	@Update("update users set name=#{name},age=#{age} where id=#{id}")
	public int update(User user);
	
	@Select("select * from users where id=#{id}")
	public User getById(int id);
	
	@Select("select * from users")
	public List<User> getAll();
}
