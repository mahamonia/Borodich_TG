package com.roditeli.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.roditeli.api.dao.IUserDao;
import com.roditeli.model.Theme;
import com.roditeli.model.User;

@Repository
public class UserDao extends BaseDao<User>implements IUserDao{

	public UserDao() {
		super(User.class);
	}

	@Override
	public User getUserbyLogin(String login) throws HibernateException{
		Criteria criteria = sessionFactory.getCurrentSession().createCriteria(clazz);
		User user = (User)criteria.createCriteria("authen", JoinType.RIGHT_OUTER_JOIN).add(Restrictions.eq("login", login)).list().get(0);
		
		return user;
	}

	
}
