package com.example.hibernatetwo.utils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

@Service
public class commonFunctions {

	public commonFunctions() {
		// TODO Auto-generated constructor stub
	}
	
	public Session createSession() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session=factory.openSession();
		return session;
	}

}
