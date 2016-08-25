package com.nj.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nj.dao.UserDAO;
import com.nj.model.User;

@Service
public class UserService implements IUserService {

	@Autowired
	private UserDAO userDAO;

	public void setUserDAO(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	public void saveUser(User user) {

		userDAO.saveUser(user);
	}

	public User getUser(Long id) {
		return userDAO.getUser(id);

	}

	public void updateUser(User user) {
		userDAO.updateUser(user);
	}

	public List<User> getUsersList() {
		List<User> users = userDAO.getUsersList();
		return users;
	}

}
