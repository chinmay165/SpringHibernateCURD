package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.pojo.Registerpojo;
import com.boraji.tutorial.spring.model.RegisterEnty;

public interface RegService {
	
	List<RegisterEnty> list();

	void saveRegister(Registerpojo regpojo);

	Registerpojo getEmpbyID(Long hid_regId);

	void updateRegister(Registerpojo regpojo);

	String deleteRegister(Long hid_regId);
}
