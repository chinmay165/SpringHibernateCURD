package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.pojo.StudentP;
import com.boraji.tutorial.spring.dao.StudentDao;
import com.boraji.tutorial.spring.dao.StudentDaoImp;
import com.boraji.tutorial.spring.model.StudentE;

@Service
public class StudentSerImp implements StudentSer{

	@Autowired
	private StudentDao stdDao;
	
	@Transactional
	public void saveStudent(StudentP stdP) {
		// TODO Auto-generated method stub
		stdDao.saveStudent(stdP);
	}

	@Transactional
	public List<StudentE> list() {
		// TODO Auto-generated method stub
		
		return stdDao.list();
	}

	@Transactional
	public StudentP getStudentDetails(long hid_cId) {
		// TODO Auto-generated method stub
		StudentP stdP = new StudentP();
		StudentE stdE = stdDao.getStudentDetails(hid_cId);
		stdP.setCardid(stdE.getCardid());
		stdP.setRollno(stdE.getRollno());
		stdP.setSname(stdE.getSname());
		stdP.setStream(stdE.getStream());
		return stdP;
	}

	@Transactional
	public void updateStudentData(StudentP stdP) {
		// TODO Auto-generated method stub
		StudentE stdE = stdDao.getStudentDetails(stdP.getCardid());
		stdE.setRollno(stdP.getRollno());
		stdE.setSname(stdP.getSname());
		stdE.setStream(stdP.getStream());
	}

	@Transactional
	public String deleteStudentData(long hid_cId) {
		// TODO Auto-generated method stub
		try {
			stdDao.deleteStudentData(hid_cId);
			return "Record Deleted";
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		
	}

}
