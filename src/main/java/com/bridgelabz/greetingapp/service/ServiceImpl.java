package com.bridgelabz.greetingapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.repository.GreetingRepository;

@Service
public class ServiceImpl implements IService {
	
	@Autowired
	GreetingRepository greetingRepo;
	@Override
	public List<Greeting> getGreetings() {
		// TODO Auto-generated method stub
		return greetingRepo.findAll();
	}

	@Override
	public Greeting getGreeting(long id) {
		// TODO Auto-generated method stub
		return greetingRepo.findById(id).orElse(null);
	}

	@Override
	public void addGreeting(Greeting msg) {
		// TODO Auto-generated method stub
		  greetingRepo.save(msg);
	}

	@Override
	public void putGreeting(Greeting msg) {
		// TODO Auto-generated method stub
		 greetingRepo.save(msg);
	}

	@Override
	public void deleteGreeting(long id) {
		// TODO Auto-generated method stub
		greetingRepo.deleteById(id);		
	}
	
}
