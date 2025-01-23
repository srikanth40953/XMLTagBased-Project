package com.example.hibernatetwo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@SpringBootApplication
public class HibernatetwoApplication {

	public static void main(String[] args) {
		SpringApplication.run(HibernatetwoApplication.class, args);
		//ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		System.out.println("inside main!");
	}
	
	

}
