package com.luv2code.springdemo;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@PropertySource("classpath:com/luv2code/springdemo/resources/config/fortunes.properties")
public class ReadFromPropertyFortuneService implements FortuneService {

    public final int MAX_ELEMENT = 2;

    @Autowired
    @Qualifier("randomFortuneService")
    private FortuneService fortuneService;

    @Value("${foo.fortune.list.elements}")
    private String[] dayFortunes;

    // define a default constructor
    public ReadFromPropertyFortuneService() {
        System.out.println("Inside default constructor: ReadFromPropertyFortuneService");
    }

    //define my init method
    @PostConstruct
    public void doMyStartupStuff(){
        System.out.println(">> ReadFromPropertyFortuneService: inside doMyStartupStuff() <<");
        System.out.println(getFortune());
        System.out.println(getDailyFortune());
    }

    @Override
    public String getFortune() {
        int element = (int) ((Math.random()) * (MAX_ELEMENT + 1));

        return dayFortunes[element];    }

    @Override
    public String getDailyFortune() {
        return "Things will work!";
    }

}
