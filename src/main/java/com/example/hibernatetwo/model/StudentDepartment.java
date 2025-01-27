package com.example.hibernatetwo.model;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Table(name="department_details")
@Entity
public class StudentDepartment {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int departmentId;
	
	@NotNull
	@Size(min=2, max=60)
	private String departmentName;
	
	@NotNull
	@Size(min=2, max=10)
	private String departmentCode;
	
	public String getDepartmentCode() {
		return departmentCode;
	}
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	public int getDepartmentId() {
		return departmentId;
	}
	public void setDepartmentId(int departmentId) {
		this.departmentId = departmentId;
	}
	public String getDepartmentName() {
		return departmentName;
	}
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	public StudentDepartment() {
		super();
	}
	public StudentDepartment(String departmentName, String departmentCode) {
		super();
		this.departmentName = departmentName;
		this.departmentCode = departmentCode;
	}
	
	
}
