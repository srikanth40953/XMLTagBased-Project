package com.example.hibernatetwo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hibernatetwo.ExceptionHandling.CustomException;
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
	
	@PostMapping("/getStudentDepartmentList")
	@ResponseBody
	public List<StudentDepartment> getStudentDepartmentList() {
		return studDepartService.getDepartmentList();
	}
	
	@PostMapping("/saveAllStudentDepartments")
	@ResponseBody
	public String saveAllStudentDepartments(@Valid @RequestBody List<StudentDepartment> departmentList) {
		return studDepartService.saveAllDepartments(departmentList);
	}
	
	@GetMapping("/customException")
	@ResponseBody
	public String customException(@RequestParam String exceptionName) throws CustomException {
		
		System.out.println("exceptionName="+exceptionName);
		
	/*	try {    METHOD-1
			throw new CustomException(exceptionName);
		} catch (Exception e) {
			return e.getMessage()+" Exception occurred!!!";
		}
	*/
		// METHOD-2
		throw new CustomException(exceptionName);
		
		
		
	}
	
}
