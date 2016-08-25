package com.nj.service;

import java.util.List;

import com.nj.model.User;

public interface IUserService {
	
	public void saveUser(User user );

	public User getUser(Long id);

	public void updateUser(User user);
	
	public List<User> getUsersList();

}
