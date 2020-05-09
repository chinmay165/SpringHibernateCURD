package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.pojo.Registerpojo;
import com.boraji.tutorial.spring.model.RegisterEnty;

public interface RegDao {

	List<RegisterEnty> list();
	void saveRegister(Registerpojo regpojo);
	RegisterEnty getEmpbyID(Long hid_regId);
	void deleteRegister(Long hid_regId);
	void updateRegister(Registerpojo regpojo);

}
