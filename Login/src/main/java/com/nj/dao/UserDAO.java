package com.nj.dao;

import java.util.List;

import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate4.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.nj.model.User;

@Repository
public class UserDAO implements IUserDAO {

	HibernateTemplate hibernateTemplate = null;

	public void setSessionFactory(SessionFactory sessionFactory) {
		hibernateTemplate = new HibernateTemplate(sessionFactory);
		hibernateTemplate.setCheckWriteOperations(false);
	}

	public void saveUser(User user) {
		hibernateTemplate.save(user);

	}

	public User getUser(Long id) {
		return hibernateTemplate.get(User.class, id);

	}

	public void updateUser(User user) {
		hibernateTemplate.update(user);

	}

	public List<User> getUsersList() {
		List<User> users = (List<User>) hibernateTemplate.find("from Users");
		return users;
	}

}
