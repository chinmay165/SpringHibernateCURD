package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.pojo.Employeepojo;
import com.boraji.tutorial.spring.model.EmployeeEnty;

public interface EmpService {
		void save(Employeepojo empojo);
		void update(Employeepojo empojo);
		
		Employeepojo getEmpbyID(String empid);
		
		List<EmployeeEnty> list(); 
}
