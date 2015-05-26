package org.duohuo.mapper;

import java.util.List;

import org.duohuo.po.User;



public interface UserMapper {
	//根据用户名称 查询用户信息
		public User  findUserByUsername(String username) throws Exception;
		
		//查询用户列表
		public List<User> findUserList()throws Exception;
}
