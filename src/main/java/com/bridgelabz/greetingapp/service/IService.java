package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.model.Greeting;

public interface IService {
	public List<Greeting> getGreetings();
	public Greeting getGreeting(long id);
	public void addGreeting(Greeting msg);
	public void putGreeting(Greeting msg);
	public void deleteGreeting(long id);
}
