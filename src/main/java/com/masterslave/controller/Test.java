package com.masterslave.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.masterslave.mapper.UserMapper;
import com.masterslave.model.User;
import com.masterslave.service.UserService;

@Controller
@RequestMapping("test")
public class Test {

	@Autowired
	private UserService userService;
	
	@RequestMapping("test")
	@ResponseBody
	public String test(String name) {
		return "hello";
	}
	
	@RequestMapping("getUser")
	@ResponseBody
	public String getUser(String name) {
		List<User> users = userService.getUserByName(name);
		System.out.println("size = "+users.size());
		System.out.println(JSON.toJSON(users));
		return JSON.toJSON(users).toString();
	}
	
	@RequestMapping("updateUser")
	@ResponseBody
	public String updateUser(String name,String pwd) {
		int i = userService.updateByName(name, pwd);
		return i+"";
	}
	
	@RequestMapping("deleteUser")
	@ResponseBody
	public String deleteUser(Integer id) {
		int i = userService.deleteUser(id);
		return i+"";
	}
	
	@RequestMapping("saveUser")
	@ResponseBody
	public String saveUser(String name,String pwd) {
		User user = new User();
		user.setName(name);
		user.setPwd(pwd);
		int i = userService.saveUser(user);
		return i+"";
	}
}
