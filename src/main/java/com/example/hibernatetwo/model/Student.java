package com.example.hibernatetwo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long rollNum;
	private String studentName;
	private float attendancePercentage;
	private String departmentName;
	
	
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	
	public Student(String studentName, float attendancePercentage, String departmentName) {
		super();
		this.studentName = studentName;
		this.attendancePercentage = attendancePercentage;
		this.departmentName = departmentName;
	}

	public Student() {
		
	}
	
	public long getRollNum() {
		return rollNum;
	}
	public void setRollNum(long rollNum) {
		this.rollNum = rollNum;
	}

	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public float getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(float attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	public Student(String studentName, float attendancePercentage) {
		super();
		this.studentName = studentName;
		this.attendancePercentage = attendancePercentage;
	}
	
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", studentName=" + studentName + ", attendancePercentage="
				+ attendancePercentage + ", departmentId=" + departmentName + "]";
	}
	
	


}
