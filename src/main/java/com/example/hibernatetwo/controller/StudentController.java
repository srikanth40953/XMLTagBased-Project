package com.example.hibernatetwo.controller;

import java.math.BigDecimal;
import java.util.List;

//import javax.validation.Valid;
//import org.springframework.validation.annotation.Validated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.hibernatetwo.model.Student;
import com.example.hibernatetwo.service.StudentService;

import jakarta.validation.Valid;
//import javax.validation.Valid;

import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class StudentController {
	
	private StudentService studentService;
	
	@Autowired
	public void setStudentService(StudentService stService) {
		this.studentService = stService;
	}

	@GetMapping("/testController")
	@ResponseBody
	public String testController() {
		System.out.println("inside test Controller!");
		String str = studentService.testStudentService();
		return str;
	}

	@PostMapping("/createStudent")
	@ResponseBody
	public String insertStudentRecord(@Valid @RequestBody Student student) {
		System.out.println("inside createStudent controller");
		String str = studentService.saveStudentDetailsService(student);
		return str;
	}
	
	@PostMapping("/updateStudent/{name}")
	@ResponseBody
	public String updateStudentAttendance(@RequestParam BigDecimal attendance,
			@PathVariable String name) {
		String str= studentService.updateStudentAttendance(attendance, name);
		return str;
	}
	
	@ResponseBody
	@RequestMapping(value="/getStudentList", method=RequestMethod.GET)
	public List<Student> getStudentList(){
		List<Student> studentList = studentService.getStudentsList();
		System.out.println("studentList="+studentList);
		return studentList;
	}
	
	@ResponseBody
	@PatchMapping("/saveMultipleStudents")
	public String saveMultipleStudents(@RequestBody List<Student> students) {
		String str = studentService.saveAllStudents(students);
		return str;
	}
	
}
