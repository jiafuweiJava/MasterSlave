package com.masterslave.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.masterslave.mapper.UserMapper;
import com.masterslave.model.User;
import com.masterslave.model.UserCriteria;

@Service
public class UserService {
	
	@Autowired
	UserMapper userMapper;
	
	/**
	 * 查询User
	 * @param name
	 * @return
	 */
	public List<User> getUserByName(String name) {
		UserCriteria example = new UserCriteria();
		example.createCriteria().andNameEqualTo(name);
		return userMapper.selectByExample(example);
	}
	/**
	 * 修改User
	 * @param name
	 * @param pwd
	 * @return
	 */
	public int updateByName(String name,String pwd) {
		UserCriteria example = new UserCriteria();
		example.createCriteria().andNameEqualTo(name);
		User record = new User();
		record.setPwd(pwd);
		return userMapper.updateByExampleSelective(record, example);
	}
	
	/**
	 * 增加一个User
	 * @param user
	 * @return
	 */
	public int saveUser(User user) {
		
		return userMapper.insert(user);
	}
	/**
	 * 删除一个User
	 * @param id
	 * @return
	 */
	public int deleteUser(Integer id) {
		UserCriteria example = new UserCriteria();
		example.createCriteria().andIdEqualTo(id);
		
		return userMapper.deleteByPrimaryKey(id);
	}
}
