package com.example.hibernatetwo.model;

import java.math.BigDecimal;

//import jakarta.validation.constraints.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
@Table(name="student_details")
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int rollNum;
	
	
	@Size(min=2, max=40)
	@NotNull
	private String studentName;
	
	@Digits(integer=3, fraction=2)
	@DecimalMax(value="100")
	@NotNull
	private BigDecimal attendancePercentage;
	
	@Digits(integer=2, fraction=0)
	@DecimalMax(value="10")
	@NotNull
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
	public BigDecimal getAttendancePercentage() {
		return attendancePercentage;
	}
	public void setAttendancePercentage(BigDecimal attendancePercentage) {
		this.attendancePercentage = attendancePercentage;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	
	public Student(int rollNum, String studentName, BigDecimal attendancePercentage, int departmentId) {
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
