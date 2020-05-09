package com.boraji.pojo;

import javax.persistence.Column;

public class Registerpojo {

	
	private long regId;
	private String name;
	private String sex;
	private String email;
	private String addr;
	
	public long getRegId() {
		return regId;
	}
	public void setRegId(long regId) {
		this.regId = regId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getAddr() {
		return addr;
	}

	public void setAddr(String addr) {
		this.addr = addr;
	}
	
	
	
}
