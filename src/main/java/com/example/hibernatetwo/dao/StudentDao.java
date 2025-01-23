package com.example.hibernatetwo.dao;

import org.springframework.stereotype.Repository;

import com.example.hibernatetwo.model.Student;
import java.util.List;

@Repository
public interface StudentDao {

	String testStudentDao();

	String saveStudentDetailsDao(Student student);
	String updateStudentAttendance(float attendance, String name);
	List<Student> getStudentsList();
	
}
