package com.nj.dao;

import java.util.List;

import com.nj.model.User;

public interface IUserDAO {

	public void saveUser(User user );

	public User getUser(Long id);

	public void updateUser(User user);
	
	
	public List<User> getUsersList();
}
