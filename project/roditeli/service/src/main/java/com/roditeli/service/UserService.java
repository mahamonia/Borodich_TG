package com.roditeli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.roditeli.api.dao.IUserDao;
import com.roditeli.api.service.IUserService;
import com.roditeli.model.User;

@Service
public class UserService extends BaseService<User> implements IUserService{
	
	@Autowired
	private IUserDao dao;
	
	public UserService() {
	}

	@Override
	@Transactional
	public User getUser(String login) {
		User user = null;
			try {
				user = dao.getUserbyLogin(login);
			} catch (Exception e) {
				LOGGER.error(e.getMessage());
			}
			return user;
	}

}
