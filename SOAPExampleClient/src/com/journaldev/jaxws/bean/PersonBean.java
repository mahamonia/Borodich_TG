package com.journaldev.jaxws.bean;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.journaldev.jaxws.beans.Person;
import com.journaldev.jaxws.service.PersonServiceImpl;

public class PersonBean {
	
	private List<Person> persons;
	private PersonServiceImpl service;
	
	public List<Person> getPersons(){
		
		try {
			return Arrays.asList(service.getAllPersons());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new ArrayList<>();
	}

}
