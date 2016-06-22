package com.roditeli.dao;

import org.springframework.stereotype.Repository;

import com.roditeli.api.dao.IEventDao;
import com.roditeli.model.Event;

@Repository
public class EventDao extends BaseDao<Event> implements IEventDao{

	public EventDao() {
		super(Event.class);
	}


	
}
