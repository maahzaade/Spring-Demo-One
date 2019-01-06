package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.sql.SQLOutput;

@Component
public class PingPongCoach implements Coach {

	@Autowired
	@Qualifier("randomFortuneService")
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
//	@Autowired
//	public void doSomeCrazyStuff(FortuneService fortuneService) {
//		System.out.println("Inside method: doSomeCrazyStuff(FortuneService fortuneService)");
//		this.fortuneService = fortuneService;
//	}


	//define my init method
	@PostConstruct
	public void doMyStartupStuff(){
		System.out.println(">> PingPongCoach: inside doMyStartupStuff() <<");
	}


	//define my destroy method
	@PreDestroy
	public void doMyCleantupStuff(){
		System.out.println(">> PingPongCoach: inside doMyCleantupStuff() <<");
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
