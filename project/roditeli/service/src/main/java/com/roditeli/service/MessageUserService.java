package com.roditeli.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Service;

import com.roditeli.api.dao.IMessageUserDao;
import com.roditeli.api.service.IMessageUserService;
import com.roditeli.model.MessageUser;

@Service
public class MessageUserService extends BaseService<MessageUser> implements IMessageUserService{
	@Autowired
	private IMessageUserDao dao;

	
	public MessageUserService() {
	}
	

}
