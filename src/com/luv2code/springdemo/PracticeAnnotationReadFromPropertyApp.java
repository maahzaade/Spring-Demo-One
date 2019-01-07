package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationReadFromPropertyApp {


    public static void main(String[] args) {

        // read spring config file
        ClassPathXmlApplicationContext context =
                new ClassPathXmlApplicationContext("applicationContext.xml");

        // get the bean from spring container
        FortuneService theFortuneService = context.getBean("readFromPropertyFortuneService", FortuneService.class);

        // call a method on the bean
        //System.out.println(theFortuneService.getFortune());

        // call method to get the daily fortune
        //System.out.println(theFortuneService.getDailyFortune());

        // close the context
        context.close();

    }

}
