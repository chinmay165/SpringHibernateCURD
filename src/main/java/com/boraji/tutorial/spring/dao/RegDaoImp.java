package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.pojo.Registerpojo;
import com.boraji.tutorial.spring.model.EmployeeEnty;
import com.boraji.tutorial.spring.model.RegisterEnty;


@Repository
public class RegDaoImp implements RegDao{
	@Autowired
	private SessionFactory sessionfactory;

	@Override
	public List<RegisterEnty> list() {
		// TODO Auto-generated method stub
		TypedQuery<RegisterEnty> regQuery = sessionfactory.getCurrentSession().createQuery("from RegisterEnty");
		return regQuery.getResultList();
	}

	@Override
	public void saveRegister(Registerpojo regpojo) {
		// TODO Auto-generated method stub
		RegisterEnty regEnty = new RegisterEnty();
		regEnty.setName(regpojo.getName());
		regEnty.setSex(regpojo.getSex());
		regEnty.setEmail(regpojo.getEmail());
		regEnty.setAddr(regpojo.getAddr());
		
		//sessionfactory.getCurrentSession().save(regEnty);
	}

	@Override
	public RegisterEnty getEmpbyID(Long hid_regId) {
		// TODO Auto-generated method stub
		RegisterEnty regEty = sessionfactory.getCurrentSession().load(RegisterEnty.class, hid_regId);
		return regEty;
		
	}

	@Override
	public void deleteRegister(Long hid_regId) {
		// TODO Auto-generated method stub
		RegisterEnty regEty = null;
		Session session = sessionfactory.getCurrentSession();
		regEty = session.load(RegisterEnty.class, hid_regId);
		session.delete(regEty);
	}

	@Override
	public void updateRegister(Registerpojo regpojo) {
		// TODO Auto-generated method stub
		RegisterEnty regEnty = getEmpbyID(regpojo.getRegId());
		regEnty.setName(regpojo.getName());
		regEnty.setSex(regpojo.getSex());
		regEnty.setAddr(regpojo.getAddr());
		regEnty.setEmail(regpojo.getEmail());
		
		//sessionfactory.getCurrentSession().update(regEnty);
	}

	

	

}
