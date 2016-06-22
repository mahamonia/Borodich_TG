package com.roditeli.api.dao;

import java.util.List;

import org.hibernate.HibernateException;

import com.roditeli.model.Theme;
import com.roditeli.model.User;


public interface IUserDao extends IBaseDao<User>{
	
	public User getUserbyLogin(String login) throws Exception;
	
	

}
