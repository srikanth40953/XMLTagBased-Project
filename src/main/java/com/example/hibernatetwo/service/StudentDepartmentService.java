package com.example.hibernatetwo.service;

import java.util.List;
import com.example.hibernatetwo.model.StudentDepartment;

public interface StudentDepartmentService {

	String saveDepartmentDetailsDao(StudentDepartment studDepartment);
	List<StudentDepartment> getDepartmentList();
	String saveAllDepartments(List<StudentDepartment> studentDepartments);
	
	
}
