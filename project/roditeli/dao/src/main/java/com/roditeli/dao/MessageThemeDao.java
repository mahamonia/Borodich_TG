package com.roditeli.dao;

import org.springframework.stereotype.Repository;

import com.roditeli.api.dao.IMessageThemeDao;
import com.roditeli.model.MessageTheme;

@Repository
public class MessageThemeDao extends BaseDao<MessageTheme>implements IMessageThemeDao{

	public MessageThemeDao() {
		super(MessageTheme.class);
	}


	
}
