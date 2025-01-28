package com.example.hibernatetwo.service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

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
	String updateStudentAttendance(BigDecimal attendance, String name);
	List<Student> getStudentsList();
	String saveAllStudents(List<Student> students);
	List<Map<String,String>> getAllStudentsAccToDepartment();
}
