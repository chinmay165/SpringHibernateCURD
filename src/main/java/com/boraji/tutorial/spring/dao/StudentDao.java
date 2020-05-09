package com.boraji.tutorial.spring.dao;

import java.util.List;

import com.boraji.pojo.StudentP;
import com.boraji.tutorial.spring.model.StudentE;

public interface StudentDao {

	void saveStudent(StudentP stdP);

	List<StudentE> list();

	StudentE getStudentDetails(long hid_cId);

	void deleteStudentData(long hid_cId);

	

}
