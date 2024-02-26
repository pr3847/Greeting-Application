package com.bridgelabz.greetingapp.dao;




import org.springframework.data.jpa.repository.JpaRepository;

import com.bridgelabz.greetingapp.entities.GreetingEntities;

public interface GreetingDao extends JpaRepository<GreetingEntities, Long> {

}
