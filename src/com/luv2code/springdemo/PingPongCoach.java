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

//	@Autowired
//	public PingPongCoach(FortuneService fortuneService) {
//		System.out.println("Inside constructor: PingPongCoach(FortuneService fortuneService)");
//		this.fortuneService = fortuneService;
//
//	}

//	Define a setter method
//	@Autowired
//	public void setFortuneService(FortuneService fortuneService) {
// 		System.out.println("Inside setter: setFortuneService(FortuneService fortuneService)");
//		this.fortuneService = fortuneService;
//	}

	// Test injection with method
	@Autowired
	public void doSomeCrazyStuff(FortuneService fortuneService) {
		System.out.println("Inside method: doSomeCrazyStuff(FortuneService fortuneService)");
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
