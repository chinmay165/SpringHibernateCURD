package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.pojo.Employeepojo;
import com.boraji.tutorial.spring.model.EmployeeEnty;
import com.boraji.tutorial.spring.model.User;

@Repository
public class EmpDaoImp implements EmpDao{

	@Autowired
	private SessionFactory sessionFactory; 
	
	@Override
	public void save(Employeepojo empojo) {
		// TODO Auto-generated method stub
		EmployeeEnty empEty = new EmployeeEnty();
		empEty.setEmpName(empojo.getEmpName());
		empEty.setDesignation(empojo.getDesignation());
		empEty.setGender(empojo.getGender());
		
		sessionFactory.getCurrentSession().save(empEty);
	}

	@Override
	public List<EmployeeEnty> list() {
		// TODO Auto-generated method stub
		TypedQuery<EmployeeEnty> query = sessionFactory.getCurrentSession().createQuery("from EmployeeEnty");
		return query.getResultList();
	}

	@Override
	public EmployeeEnty getEmpbyID(String empid) {
		// TODO Auto-generated method stub
		System.out.println(Long.parseLong(empid));
		EmployeeEnty empEty = sessionFactory.getCurrentSession().load(EmployeeEnty.class, Long.parseLong(empid));
		return empEty;
		}

	@Override
	public void deleteEmployee(String empid) {
		// TODO Auto-generated method stub
		EmployeeEnty empEty = null;
		Session session = sessionFactory.getCurrentSession();
		empEty = session.load(EmployeeEnty.class, Long.parseLong(empid));
		session.delete(empEty);
						
	}

	
	

}
