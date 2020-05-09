package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.pojo.Employeepojo;
import com.boraji.tutorial.spring.model.EmployeeEnty;
import com.boraji.tutorial.spring.model.RegisterEnty;

public interface EmpService {
		void save(Employeepojo empojo);
		void update(Employeepojo empojo);
		void delete(String empid);
		
		Employeepojo getEmpbyID(String empid);
		
		List<EmployeeEnty> list();
		String deleteEmployee(String empid);
		 
}
