package com.example.hibernatetwo.service;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import com.example.hibernatetwo.model.Student;

@Service
public interface StudentService {

	String testStudentService();
	String saveStudentDetailsService(Student student);
	Session createStudentSession();
	String updateStudentAttendance(float attendance, String name);
	List<Student> getStudentsList();

}
