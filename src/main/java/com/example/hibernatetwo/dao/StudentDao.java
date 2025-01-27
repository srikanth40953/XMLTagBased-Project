package com.example.hibernatetwo.dao;

import org.springframework.stereotype.Repository;

import com.example.hibernatetwo.model.Student;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface StudentDao {

	String testStudentDao();

	String saveStudentDetailsDao(Student student);
	String updateStudentAttendance(BigDecimal attendance, String name);
	List<Student> getStudentsList();
	String saveAllStudents(List<Student> students);
	List<Object[]> getAllStudentsAccToDepartment();
	
}
