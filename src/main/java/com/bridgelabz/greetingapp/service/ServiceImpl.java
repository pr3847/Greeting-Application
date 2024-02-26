package com.bridgelabz.greetingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.dao.GreetingDao;
import com.bridgelabz.greetingapp.entities.GreetingEntities;

@Service
public class ServiceImpl implements MyService {
	
	@Autowired
	GreetingDao greetingDao;
	@Override
	public List<GreetingEntities> getGreetings() {
		// TODO Auto-generated method stub
		return greetingDao.findAll();
	}

	@Override
	public GreetingEntities getGreeting(long id) {
		// TODO Auto-generated method stub
		return greetingDao.findById(id).get();
	}

	@Override
	public void addGreeting(GreetingEntities msg) {
		// TODO Auto-generated method stub
		  greetingDao.save(msg);
	}

	@Override
	public void putGreeting(GreetingEntities msg) {
		// TODO Auto-generated method stub
		 greetingDao.save(msg);
	}

	@Override
	public void deleteGreeting(long id) {
		// TODO Auto-generated method stub
		greetingDao.deleteById(id);		
	}
	
}
