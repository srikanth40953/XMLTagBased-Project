package com.example.hibernatetwo.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hibernatetwo.dao.StudentDepartmentDao;
import com.example.hibernatetwo.model.StudentDepartment;
import com.example.hibernatetwo.service.StudentDepartmentService;

@Service
public class StudentDepartmentServiceImpl implements StudentDepartmentService {

	private StudentDepartmentDao studDepartDao;
	
	@Autowired
	public void setStudentDepartmentDao(StudentDepartmentDao studentDepartmentDao) {
		this.studDepartDao=studentDepartmentDao;
	}

	@Override
	public String saveDepartmentDetailsDao(StudentDepartment studDepartment) {
		String str=studDepartDao.saveDepartmentDetailsDao(studDepartment);
		return str;
	}

	@Override
	public List<StudentDepartment> getDepartmentList() {
		return studDepartDao.getDepartmentList();
	}

	@Override
	public String saveAllDepartments(List<StudentDepartment> studentDepartments) {
		return studDepartDao.saveAllDepartments(studentDepartments);
	}

	
	

}
