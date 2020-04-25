package com.boraji.tutorial.spring.service;

import java.util.List;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.pojo.Employeepojo;
import com.boraji.tutorial.spring.dao.EmpDao;
import com.boraji.tutorial.spring.model.EmployeeEnty;

@Service
public class EmpServiceImp implements EmpService{

	@Autowired
	private EmpDao empdao;
	
	@Transactional
	public void save(Employeepojo empojo) {
		// TODO Auto-generated method stub
		empdao.save(empojo);
		
	}

	@Transactional
	public List<EmployeeEnty> list() {
		// TODO Auto-generated method stub
		
		return empdao.list();
	}

	@Transactional
	public Employeepojo getEmpbyID(String empid) {
		// TODO Auto-generated method stub
		Employeepojo empojo = new Employeepojo();
		EmployeeEnty empEty = empdao.getEmpbyID(empid);
		empojo.setEmpId(empEty.getEmpId());
		empojo.setEmpName(empEty.getEmpName());
		empojo.setDesignation(empEty.getDesignation());
		empojo.setGender(empEty.getGender());
		return  empojo;
	}

	@Transactional
	public void update(Employeepojo empojo) {
			
		EmployeeEnty empEty = empdao.getEmpbyID(String.valueOf(empojo.getEmpId()));
		empEty.setEmpName(empojo.getEmpName());
		empEty.setDesignation(empojo.getDesignation());
		empEty.setGender(empojo.getGender());
				
	}

	
	
}
