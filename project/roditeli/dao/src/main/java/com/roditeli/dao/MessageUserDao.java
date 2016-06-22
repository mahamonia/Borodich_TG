package com.roditeli.dao;

import org.springframework.stereotype.Repository;

import com.roditeli.api.dao.IMessageUserDao;
import com.roditeli.model.MessageUser;

@Repository
public class MessageUserDao extends BaseDao<MessageUser> implements IMessageUserDao{

	public MessageUserDao() {
		super(MessageUser.class);
	}


	
}
