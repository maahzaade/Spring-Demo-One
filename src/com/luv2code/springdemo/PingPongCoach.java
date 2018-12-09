package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	private FortuneService fortuneService;

	// define a default constructor
	public PingPongCoach() {
		System.out.println("Inside default constructor: PingPongCoach");
	}

	@Autowired
	public PingPongCoach(FortuneService fortuneService) {
		System.out.println("Inside constructor: PingPongCoach(FortuneService fortuneService)");
		this.fortuneService = fortuneService;

	}

	@Override
	public String getDailyWorkout() {
		return "Practice your pingpong drop shot";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
