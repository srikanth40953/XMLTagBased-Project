package com.example.hibernatetwo.dao;

import java.util.List;
import com.example.hibernatetwo.model.StudentDepartment;

public interface StudentDepartmentDao {

	String saveDepartmentDetailsDao(StudentDepartment studDepartment);
	String updateDepartmentName(int studDepartmentId, String studDepartmentName);
	List<StudentDepartment> getDepartmentList();
	String saveAllDepartments(List<StudentDepartment> studentDepartments);
	
}
