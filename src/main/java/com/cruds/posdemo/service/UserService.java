package com.cruds.posdemo.service;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cruds.posdemo.db.UserDAOHbrImpl;
import com.cruds.posdemo.db.UserDao;

import com.cruds.posdemo.entity.User;


@Service
public class UserService {
	
	@Autowired
	UserDao dao1;
	
	public boolean create(User user)
	{
		return dao1.create(user);
	}
	
	public static String authenticateUser(String usertName,String password)
	{
		UserDAOHbrImpl dao = new UserDAOHbrImpl();
		return dao.authenticateUser(usertName,password);
	}
	
	public  List<User> getAllUser()
	{
		return dao1.getAllUser();
	}	

}
