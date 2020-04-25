package com.boraji.pojo;

import javax.persistence.Column;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;

public class Employeepojo {
	
	private Long empId;
	
	@Size(max=20, min=3, message="emp.invalid.name")
	private String empName;
	
	@Size(max=20, min=3, message="emp.invalid.desig")
	private String designation;
	
	@NotBlank(message="Please select Gender")
	private String gender;

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Long getEmpId() {
		return empId;
	}

	public void setEmpId(Long empId) {
		this.empId = empId;
	}
	
	

}
