package com.boraji.tutorial.spring.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.boraji.pojo.StudentP;
import com.boraji.tutorial.spring.model.StudentE;

@Repository
public class StudentDaoImp implements StudentDao{
	
		@Autowired
		private SessionFactory sessionFactory;
	

	@Override
	public void saveStudent(StudentP stdP) {
		// TODO Auto-generated method stub
		StudentE stdE = new StudentE();
		stdE.setRollno(stdP.getRollno());
		stdE.setSname(stdP.getSname());
		stdE.setStream(stdP.getStream());
		
		sessionFactory.getCurrentSession().save(stdE);
	}


	@Override
	public List<StudentE> list() {
		// TODO Auto-generated method stub
		TypedQuery<StudentE> query = sessionFactory.getCurrentSession().createQuery("from StudentE");
		return query.getResultList();
	}


	@Override
	public StudentE getStudentDetails(long hid_cId) {
		// TODO Auto-generated method stub
		StudentE stdE = sessionFactory.getCurrentSession().load(StudentE.class, hid_cId);
		
		return stdE;
	}


	@Override
	public void deleteStudentData(long hid_cId) {
		// TODO Auto-generated method stub
		StudentE stdE = null;
		Session sesison = sessionFactory.getCurrentSession();
		stdE = sesison.load(StudentE.class, hid_cId);
		sesison.delete(stdE);
		
	}

}
