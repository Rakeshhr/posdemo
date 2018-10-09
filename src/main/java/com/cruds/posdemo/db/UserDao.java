package com.cruds.posdemo.db;

import java.time.LocalDate;
import java.util.List;


import com.cruds.posdemo.entity.User;

public interface UserDao {
	
	public boolean create(User user);
	public String authenticateUser(String firstName,String password );
	public List<User> getAllUser();
	
}
