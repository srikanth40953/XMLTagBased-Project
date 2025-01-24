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
	private int rollNum;
	private String studentName;
	private float attendancePercentage;
	private int departmentId;
	public int getRollNum() {
		return rollNum;
	}
	public void setRollNum(int rollNum) {
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
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public Student(int rollNum, String studentName, float attendancePercentage, int departmentId) {
		super();
		this.studentName = studentName;
		this.attendancePercentage = attendancePercentage;
		this.departmentId = departmentId;
	}
	
	@Override
	public String toString() {
		return "Student [rollNum=" + rollNum + ", studentName=" + studentName + ", attendancePercentage="
				+ attendancePercentage + ", departmentId=" + departmentId + "]";
	}
	
	public Student(){
		
	}

}
