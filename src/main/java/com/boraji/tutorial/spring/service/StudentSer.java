package com.boraji.tutorial.spring.service;

import java.util.List;

import com.boraji.pojo.StudentP;
import com.boraji.tutorial.spring.model.StudentE;

public interface StudentSer {

	void saveStudent(StudentP stdP);

	List<StudentE> list();

	StudentP getStudentDetails(long hid_cId);

	void updateStudentData(StudentP stdP);

	String deleteStudentData(long hid_cId);

}
