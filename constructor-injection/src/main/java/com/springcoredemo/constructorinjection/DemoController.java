package com.springcoredemo.constructorinjection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	private Coach myCoach;
	
	//Constructor Injection
	@Autowired
	public DemoController(Coach theCoach)
	{
		myCoach = theCoach;
	}
	
	@GetMapping("/dailyworkout")
	public String getDailyWorkout()
	{
		return myCoach.getDailyWorkout();
	}
	
}
