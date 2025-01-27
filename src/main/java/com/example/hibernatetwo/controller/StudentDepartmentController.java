package com.example.hibernatetwo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hibernatetwo.model.StudentDepartment;
import com.example.hibernatetwo.service.StudentDepartmentService;

import jakarta.validation.Valid;

@Controller
public class StudentDepartmentController {

	@Autowired
	private StudentDepartmentService studDepartService;
	
	@PostMapping("/saveStudentDepartment")
	@ResponseBody
	public String saveStudentDepartment(@Valid @RequestBody StudentDepartment department) {
		String str = studDepartService.saveDepartmentDetailsDao(department);
		return str;
	}
	
	
}
