package com.boraji.tutorial.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.boraji.pojo.Registerpojo;
import com.boraji.tutorial.spring.dao.RegDao;
import com.boraji.tutorial.spring.model.RegisterEnty;

@Service
public class RegServiceImp implements RegService{
	
	@Autowired
	private RegDao regDao;

	@Transactional
	public List<RegisterEnty> list() {
		// TODO Auto-generated method stub
		return regDao.list();
	}

	@Transactional
	public void saveRegister(Registerpojo regpojo) {
		// TODO Auto-generated method stub
		regDao.saveRegister(regpojo);
	}

	@Transactional
	public Registerpojo getEmpbyID(Long hid_regId) {
		// TODO Auto-generated method stub
		Registerpojo regpojo = new Registerpojo();
		RegisterEnty regEnty = regDao.getEmpbyID(hid_regId);
		
		regpojo.setRegId(regEnty.getRegId());
		regpojo.setName(regEnty.getName());
		regpojo.setSex(regEnty.getSex());
		regpojo.setAddr(regEnty.getAddr());
		regpojo.setEmail(regEnty.getEmail());
		
		return regpojo;
		
	}

	@Transactional
	public void updateRegister(Registerpojo regpojo) {
		// TODO Auto-generated method stub
		   System.out.println("update Register method service");

		/*RegisterEnty regEnty = regDao.getEmpbyID(regpojo.getRegId());
		regEnty.setName(regpojo.getName());
		regEnty.setSex(regpojo.getSex());
		regEnty.setAddr(regpojo.getAddr());
		regEnty.setEmail(regpojo.getEmail());*/
		   
		   
		   regDao.updateRegister(regpojo);
		
		
		
		
	}

	@Transactional
	public String deleteRegister(Long hid_regId) {
		// TODO Auto-generated method stub
		try {
			regDao.deleteRegister(hid_regId);
			return "Record update succefully";
			
		}catch(Exception e) {
			e.printStackTrace();
			return "Failed";
		}
		
	}

	
	
}
