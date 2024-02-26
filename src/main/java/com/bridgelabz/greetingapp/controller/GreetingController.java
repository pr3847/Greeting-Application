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

import com.bridgelabz.greetingapp.entities.GreetingEntities;
import com.bridgelabz.greetingapp.service.MyService;

@RestController
public class GreetingController {
	
	@Autowired
	MyService service;
	
	@GetMapping("/greetings")
	public List<GreetingEntities> getGreetings(){
		return this.service.getGreetings();
	}
	
	@GetMapping("/greetings/{greetingId}")
	public GreetingEntities getGreeting(@PathVariable String greetingId) {
		return this.service.getGreeting(Long.parseLong(greetingId));
	}
	
	@PostMapping("/greetings")
	public ResponseEntity<HttpStatus> addGreeting(@RequestBody GreetingEntities msg){
		try{
			this.service.addGreeting(msg);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@PutMapping("/greetings")
	public ResponseEntity<HttpStatus> updateGreeting(@RequestBody GreetingEntities msg){
		try{
			this.service.putGreeting(msg);
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	@DeleteMapping("/greetings/{greetingId}")
	public ResponseEntity<HttpStatus> deleteGreeting(@PathVariable String greetingId){
		try{
			this.service.deleteGreeting(Long.parseLong(greetingId));
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}
