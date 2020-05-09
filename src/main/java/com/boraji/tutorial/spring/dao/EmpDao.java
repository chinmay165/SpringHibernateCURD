package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.pojo.Employeepojo;
import com.boraji.tutorial.spring.model.EmployeeEnty;

public interface EmpDao {

	void save(Employeepojo empojo);
	EmployeeEnty getEmpbyID(String empid);

	   List<EmployeeEnty> list();
	void deleteEmployee(String empid);
	
}
