package com.bridgelabz.greetingapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greetingapp.model.Greeting;
import com.bridgelabz.greetingapp.service.IService;

@RestController
public class GreetingController {
	
	@Autowired
	IService service;
	
	@GetMapping("/getgreetings")
	public List<Greeting> getGreetings(){
		return this.service.getGreetings();
	}
	
	@GetMapping("/getgreeting/{greetingId}")
	public Greeting getGreeting(@PathVariable String greetingId) {
		return this.service.getGreeting(Long.parseLong(greetingId));
	}
	
	@PostMapping("/postgreetings")
	public ResponseEntity<String> addGreeting(@RequestBody Greeting msg){
		try{
			this.service.addGreeting(msg);
			return new ResponseEntity<>("Added successfully.",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/putgreetings")
	public ResponseEntity<String> updateGreeting(@RequestBody Greeting msg){
		try{
			this.service.putGreeting(msg);
			return new ResponseEntity<>("Updated successfully.",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/deletegreetings/{greetingId}")
	public ResponseEntity<String> deleteGreeting(@PathVariable String greetingId){
		try{
			this.service.deleteGreeting(Long.parseLong(greetingId));
			return new ResponseEntity<>("Deleted successfully.",HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
