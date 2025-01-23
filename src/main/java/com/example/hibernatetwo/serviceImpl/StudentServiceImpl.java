package com.example.hibernatetwo.serviceImpl;

import org.springframework.orm.hibernate5.LocalSessionFactoryBean;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernatetwo.dao.StudentDao;
import com.example.hibernatetwo.model.Student;
import com.example.hibernatetwo.service.StudentService;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@Service
public class StudentServiceImpl implements StudentService{

	//private StudentDao studentDao;
	
	//constructor injection
	/*
	 * public StudentServiceImpl(StudentDao stuDao) { this.studentDao=stuDao; }
	 */
	
    private StudentDao studentDao;

	//@Autowired for constructor is not required in any class (working)
	
	/*
	 * public StudentServiceImpl(StudentDao stuDao) { this.studentDao = stuDao; }
	 */
	
	/* 
	 * In below setStudentDao() :
	 * setting bean using setter injection also working here getting StudentDao Bean
	 * which is set in StudentService Bean
	 */
	@Autowired
	public void setStudentDao(StudentDao stuDao) {
		this.studentDao = stuDao;
	}
	
	/*
	 * private LocalSessionFactoryBean localSessionFactoryBean;
	 * 
	 * @Autowired public void setLocalSessionFactoryBean(LocalSessionFactoryBean
	 * sesnFactry) { this.localSessionFactoryBean = sesnFactry; }
	 */
	
	// By using below way we call our applicationContext.xml file manually whenever required
	// ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	// StudentDao StudentDao = context.getBean(StudentDao.class);
	
	//Below code is working fine
	@Override 
	public String testStudentService() {
		System.out.println("inside testStudentService!");
		//By using below way we call our applicationContext.xml file manually whenever required
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		SessionFactory sesnFactory = context.getBean(SessionFactory.class);
		String str = studentDao.testStudentDao();
		return str;
	}
 //-------------------------------------------------------------------
	
	
	@Override
	public String saveStudentDetailsService(Student student) {
		System.out.println("inside saveStudentDetailsService");
		String str = studentDao.saveStudentDetailsDao(student);
		return str;
	}
	
	public Session createStudentSession() {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");	
		SessionFactory factory = (SessionFactory) context.getBean("sessionFactory");
		Session session=factory.openSession();
		return session;
	}

	@Override
	public String updateStudentAttendance(float attendance,String name) {
		String str = studentDao.updateStudentAttendance(attendance, name);
		return str;
	}

	@Override
	public List<Student> getStudentsList() {
		
		return studentDao.getStudentsList();
	}
	

	
}
