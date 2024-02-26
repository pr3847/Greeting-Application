package com.bridgelabz.greetingapp.service;

import java.util.List;

import com.bridgelabz.greetingapp.entities.GreetingEntities;

public interface MyService {
	public List<GreetingEntities> getGreetings();
	public GreetingEntities getGreeting(long id);
	public void addGreeting(GreetingEntities msg);
	public void putGreeting(GreetingEntities msg);
	public void deleteGreeting(long id);
}
